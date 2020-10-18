package com.dmotpan.kata_mvvm.api

import okhttp3.OkHttpClient

class OkHttpClientProvider {
    companion object {
        fun get(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(WeatherApiInterceptor())
            .build()
    }
}
