package com.example.navigation_ngang_lan3.fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface api_service {
//    http://localhost/Kien_truc/dictionary.php

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();
    api_service api_service = new Retrofit.Builder().baseUrl("http://192.168.1.101/Kien_truc/")
        .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(com.example.navigation_ngang_lan3.fragment.api_service.class);

    @GET("dictionary.php")
    Call<List<tudien_api>> convertdich();

//    @POST("tudien_lan3.json")
//    Call<List<tudien_api>> postDich(@Body String jsonDictionary);
}
