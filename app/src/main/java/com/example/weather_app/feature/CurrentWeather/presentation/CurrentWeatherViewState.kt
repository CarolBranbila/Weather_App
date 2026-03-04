package com.example.weather_app.feature.CurrentWeather.presentation

data class CurrentWeatherViewState(
    val list: List<TimePerHour>,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val localName: String = "São Paulo",
    val conditionIcon: String = "Teste",
    val conditionText: String = "Ensolarado",
    val maxTempC: String = "32",
    val minTemC : String = "22",
    val tempC : String = "28"


)

data class TimePerHour(
    val localTime:String,
    val conditionIcon: String,
    val tempC: String,
)