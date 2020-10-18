package com.dmotpan.kata_mvvm.currentweather

import com.dmotpan.kata_mvvm.api.ApiService
import com.dmotpan.kata_mvvm.api.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CurrentWeatherInteractor(private val apiService: ApiService) {
    fun getCurrentWeather(): Flow<WeatherResponse> {
        return flow {
            val response = apiService.getWeather("London")
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}
