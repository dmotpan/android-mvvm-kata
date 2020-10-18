package com.dmotpan.kata_mvvm.currentweather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmotpan.kata_mvvm.api.model.WeatherResponse
import com.dmotpan.kata_mvvm.api.status.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class CurrentWeatherViewModel(
    private val currentWeatherInteractor: CurrentWeatherInteractor
) : ViewModel() {
    private val weather = MutableLiveData<Resource<WeatherResponse>>()
    private val konfetti = MutableLiveData<Boolean>()

    init {
        fetchCurrentWeather()
    }

    fun onTemperatureClick() {
        konfetti.value = true
    }

    fun fetchCurrentWeather() {
        // TODO
        GlobalScope.launch {
            currentWeatherInteractor.getCurrentWeather()
        }
    }

    fun getCurrentWeather(): LiveData<Resource<WeatherResponse>> {
        return weather
    }

    // TODO
    fun getKonfetti(): LiveData<Boolean> {
        return konfetti
    }
}
