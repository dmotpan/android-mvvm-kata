package com.dmotpan.kata_mvvm.api

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class WeatherApiInterceptor : Interceptor {
    override fun intercept(chain: Chain): Response {
        var request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("key", "f4aa32ce5e8d413d913213633201310")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
