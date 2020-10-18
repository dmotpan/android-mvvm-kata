package com.dmotpan.kata_mvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    companion object {
        fun get(): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .client(OkHttpClientProvider.get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
