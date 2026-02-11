package com.example.weather_app.data.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("http://api.weatherapi.com/")
        .addConverterFactory(
            Json{
                ignoreUnknownKeys = true
            }
                .asConverterFactory(
                    "application/json; charset=UTF8".toMediaType())
        )
        .build()

    fun createWeatherApi() = retrofit.create<WeatherApi>()
}