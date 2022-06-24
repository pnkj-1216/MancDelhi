package com.rcdu.medu.rest;

import com.rcdu.medu.common.Variables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String BASE_URL_SERVER = Variables.main_url;

     private static  Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {


        if(retrofit!=null){
            retrofit = null;
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_SERVER)
                    .addConverterFactory(GsonConverterFactory.create( gson ))
                    .build();
        }
        return retrofit;
    }
}
