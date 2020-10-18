package com.dmotpan.kata_mvvm.api

import com.dmotpan.kata_mvvm.api.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService  {
    @GET("current.json")
    suspend fun getWeather(@Query("q") location: String): WeatherResponse
}
