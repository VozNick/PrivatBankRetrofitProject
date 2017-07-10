package com.example.vmm408.privbankretrofitproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    public ApiNetwork getApiNetwork() {
        return new Retrofit.Builder()
                .baseUrl(" https://api.privatbank.ua")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiNetwork.class);
    }

    public ApiNetwork getMapApiNetwork() {
        return new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiNetwork.class);
    }
}
