package com.example.weather_app.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getCurrentInformation(
        @Query("key") apiKey: String,
        @Query("q") city: String,
    ) : WeatherResponse

    @GET("v1/forecast.json")
    suspend fun getForecastInformation(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("days") days: Int,
    ) : WeatherForecastResponse

}