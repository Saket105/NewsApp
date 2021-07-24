package com.example.newslibrary.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsheadLines {
    private String status;
    private String totalResults;
    private List<NewsArticlesData> articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsArticlesData> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticlesData> articles) {
        this.articles = articles;
    }
}
