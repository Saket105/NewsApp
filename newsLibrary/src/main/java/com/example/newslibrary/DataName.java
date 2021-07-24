package com.example.newslibrary;

import android.content.Context;
import android.widget.Toast;

import com.example.newslibrary.Model.NewsArticlesData;
import com.example.newslibrary.Model.NewsheadLines;
import com.example.newslibrary.Utils.LibraryApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataName {

    private List<NewsArticlesData> articles = new ArrayList<>();

    public void retriveJsonNews(String country, String apiKey, Context context){

        Call<NewsheadLines> call;
        call = LibraryApiClient.getInstance().getApi().getHeadlines(country, apiKey);

        call.enqueue(new Callback<NewsheadLines>() {
            @Override
            public void onResponse(Call<NewsheadLines> call, Response<NewsheadLines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){

                    articles.clear();
                    articles = response.body().getArticles();
                }
            }

            @Override
            public void onFailure(Call<NewsheadLines> call, Throwable t) {
//                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}
