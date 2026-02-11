package com.example.weather_app.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object NetworkModule {

    @Provides
    fun provideWeatherApi(): WeatherApi = RetrofitInstance.createWeatherApi()
}