package com.dmotpan.kata_mvvm.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(
    @SerializedName("name")
    val city: String? = null,
    @SerializedName("region")
    val region: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lon")
    val lon: Double? = null,
    @SerializedName("localtime")
    val localTime: String? = null
): Serializable
