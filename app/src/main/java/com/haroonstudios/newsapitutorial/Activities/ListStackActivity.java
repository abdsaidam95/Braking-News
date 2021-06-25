package com.haroonstudios.newsapitutorial.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.haroonstudios.newsapitutorial.Adapters.StackAdapter;
import com.haroonstudios.newsapitutorial.Models.Article;
import com.haroonstudios.newsapitutorial.Models.News;
import com.haroonstudios.newsapitutorial.R;
import com.haroonstudios.newsapitutorial.Retrofit.ApiClient;
import com.haroonstudios.newsapitutorial.Retrofit.ApiInterface;
import com.haroonstudios.newsapitutorial.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import link.fls.swipestack.SwipeStack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListStackActivity extends AppCompatActivity implements SwipeStack.SwipeStackListener{


    @BindView(R.id.swipeStack) SwipeStack swipeStack;
    @BindView(R.id.relativeLayoutNoFound) RelativeLayout relativeLayoutNoFound;
    ApiInterface apiInterface;
    List<Article> arrayListArticles;

    StackAdapter stackAdapter;
    String sourceId,webHotURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_stack);
        ButterKnife.bind(this);
        init();

        getDataFromPrevious();

    }

    private  void getDataFromPrevious()
    {
        sourceId = getIntent().getStringExtra("sourceId");

        if(!sourceId.isEmpty())
        {
            loadNews(sourceId);
        }
    }

    private void loadNews(String sourceId)
    {
        apiInterface.getNewsestArticles(ApiClient.getApiUrl(sourceId, AppConstants.API_KEY))
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        arrayListArticles.clear();
                        webHotURL = response.body().getArticles().get(0).getUrl();
                        arrayListArticles.addAll(response.body().getArticles());

                        stackAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        Toast.makeText(ListStackActivity.this,"Error:"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void init()
    {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        arrayListArticles = new ArrayList<>();
        stackAdapter = new StackAdapter(arrayListArticles,this);
        swipeStack.setAdapter(stackAdapter);
        swipeStack.setListener(this);

    }






    @Override
    public void onViewSwipedToLeft(int position) {

    }

    @Override
    public void onViewSwipedToRight(int position) {

    }

    @Override
    public void onStackEmpty() {
            swipeStack.setVisibility(View.GONE);
            relativeLayoutNoFound.setVisibility(View.VISIBLE);
    }
}
