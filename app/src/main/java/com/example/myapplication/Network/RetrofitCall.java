package com.example.myapplication.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {
    private static Retrofit instance;
    private RetrofitCall(){}
    public static Retrofit getInstance(){
        if (instance !=null){
            return instance;
        }
        else {
            return instance=new Retrofit.Builder().baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/").addConverterFactory(GsonConverterFactory.create()).build();
        }
    }
}
