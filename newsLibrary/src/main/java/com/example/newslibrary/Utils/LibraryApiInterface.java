package com.example.newslibrary.Utils;

import com.example.newslibrary.Model.NewsheadLines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LibraryApiInterface {

    @GET("top-headlines")
    Call<NewsheadLines> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
