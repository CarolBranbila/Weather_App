package com.example.weather_app.feature.CurrentWeather.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyList

class CurrentWeatherViewModel {
    private val _viewState = MutableStateFlow(CurrentWeatherViewState(emptyList()))
    val viewState = _viewState.asStateFlow()
}