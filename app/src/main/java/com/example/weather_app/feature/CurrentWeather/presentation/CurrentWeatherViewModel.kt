package com.example.weather_app.feature.CurrentWeather.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.emptyList


@HiltViewModel
class CurrentWeatherViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableStateFlow(CurrentWeatherViewState(list = emptyList()))
    val viewState = _viewState.asStateFlow()
}