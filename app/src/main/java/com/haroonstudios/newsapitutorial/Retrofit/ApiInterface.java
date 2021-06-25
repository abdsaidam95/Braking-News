package com.haroonstudios.newsapitutorial.Retrofit;

import com.haroonstudios.newsapitutorial.Models.News;
import com.haroonstudios.newsapitutorial.Models.WebSite;
import com.haroonstudios.newsapitutorial.Utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface
{
    @GET("v2/sources?language=en&apiKey=" + AppConstants.API_KEY)
    Call<WebSite> getSources();

    @GET
    Call<News> getNewsestArticles(@Url String url);

}
