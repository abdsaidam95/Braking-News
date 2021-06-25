package com.haroonstudios.newsapitutorial.Activities;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.haroonstudios.newsapitutorial.Adapters.SourcesAdapter;
import com.haroonstudios.newsapitutorial.Models.Source;
import com.haroonstudios.newsapitutorial.Models.WebSite;
import com.haroonstudios.newsapitutorial.R;
import com.haroonstudios.newsapitutorial.Retrofit.ApiClient;
import com.haroonstudios.newsapitutorial.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewMainActivity) RecyclerView recyclerView;


    ApiInterface apiInterface;
    List<Source> listSources;
    SourcesAdapter adapter;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

        loadWebsitesSources();

    }

    private void loadWebsitesSources()
    {
        dialog.show();
        apiInterface.getSources().enqueue(new Callback<WebSite>() {
            @Override
            public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                dialog.dismiss();
                WebSite webSite = response.body();
                if(webSite!=null && response.body().getSources().size()>0)
                {
                    listSources.clear();
                    listSources.addAll(webSite.getSources());

                }
                else
                {
                    Toast.makeText(MainActivity.this,"No sources found",Toast.LENGTH_LONG).show();
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<WebSite> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error:"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
    }

    private void init()
    {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dialog = new SpotsDialog(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        listSources = new ArrayList<>();
        adapter = new SourcesAdapter(this,listSources);
        recyclerView.setAdapter(adapter);


    }

}
