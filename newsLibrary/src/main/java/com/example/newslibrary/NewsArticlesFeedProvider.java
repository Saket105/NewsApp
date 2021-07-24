package com.example.newslibrary;

import com.example.newslibrary.Model.NewsArticlesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsArticlesFeedProvider {
    public static List<NewsArticlesData> parse(String articleFeed, String hello){
        List<NewsArticlesData> list = new ArrayList<>();
        NewsArticlesData data = new NewsArticlesData();
        list.add(data);

        return list;
    }
}
