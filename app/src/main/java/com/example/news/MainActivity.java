package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.news.Adapter.HeadlinesAdapter;
import com.example.news.Models.Articles;
import com.example.news.Models.Headlines;
import com.example.newslibrary.DataName;
import com.example.newslibrary.Model.NewsArticlesData;
import com.example.newslibrary.NewsArticlesFeedProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    private List<Articles> articles = new ArrayList<>();
    private HeadlinesAdapter adapter;
    final String API_Key = "3ca21224709248b2b768eda0170905ae";
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.pager);

        String country = getCountry();
        fetchData(country,API_Key);

    }

    public void fetchData(String country, String apiKey){

        Call<com.example.news.Models.Headlines> call;

        call = ApiClient.getInstance().getApi().getHeadlines(country, apiKey);

        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){
                    articles.clear();
                    articles = response.body().getArticles();
                  adapter = new HeadlinesAdapter(MainActivity.this,articles);
                    viewPager2.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}