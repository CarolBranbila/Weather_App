package com.example.weather_app.feature.CurrentWeather.presentation

data class CurrentWeatherViewState(
    val list: List<TimePerHour>
)

data class TimePerHour(
    val localTime:String,
    val conditionIcon: String,
    val tempC: String,
)