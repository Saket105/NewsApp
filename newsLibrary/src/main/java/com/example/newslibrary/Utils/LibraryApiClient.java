package com.example.newslibrary.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LibraryApiClient {

    private static final String BaseURL = "https://newsapi.org/v2/";
    private static LibraryApiClient apiClient;
    private static Retrofit retrofit;

    private LibraryApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized LibraryApiClient getInstance(){
        if (apiClient == null){
            apiClient = new LibraryApiClient();
        }
        return apiClient;
    }

    public LibraryApiInterface getApi(){
        return retrofit.create(LibraryApiInterface.class);
    }
}
