package com.dmotpan.kata_mvvm.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("current")
    val currentWeather: CurrentWeather? = null
): Serializable

data class CurrentWeather(
    @SerializedName("condition")
    val condition: Condition? = null,
    @SerializedName("temp_c")
    val tempCelsius: Double? = null,
    @SerializedName("last_updated")
    val lastUpdated: String? = null
): Serializable

data class Condition(
    @SerializedName("text")
    val weather: String? = null,
    @SerializedName("icon")
    val iconUrl: String? = null
): Serializable
