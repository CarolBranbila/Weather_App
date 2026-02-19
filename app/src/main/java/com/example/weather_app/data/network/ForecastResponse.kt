package com.example.weather_app.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherForecastResponse(
    @SerialName("location")
    val location: LocationForecast,
    @SerialName("current")
    val current: CurrentForecast,
    @SerialName("forecast")
    val forecast: Forecast
)

@Serializable
data class LocationForecast (
    @SerialName("name")
    val name: String,
    @SerialName("region")
    val region: String,
    @SerialName("country")
    val country: String,
    @SerialName("lat")
    val lat: Double,
    @SerialName("lon")
    val lon: Double,
    @SerialName("tz_id")
    val tzId: String,
    @SerialName("localtime_epoch")
    val localtimeEpoch: Long,
    @SerialName("localtime")
    val localtime: String
)

@Serializable
data class CurrentForecast (
    @SerialName("last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("temp_c")
    val tempC: Double,
    @SerialName("is_day")
    val isDay: Int,
    @SerialName("condition")
    val condition: Condition,
)

@Serializable
data class ConditionForecast(
    @SerialName("text")
    val text: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("code")
    val code: Int
)

@Serializable
data class Forecast(
    @SerialName("forecastday")
    val forecastday: List<ForecastDay>
)

@Serializable
data class ForecastDay(
    @SerialName("date")
    val date: String,
    @SerialName("date_epoch")
    val dateEpoch: Long,
    @SerialName("day")
    val day: Day,
    @SerialName("hour")
    val hour: List<Hour>
)

@Serializable
data class Day(
    @SerialName("maxtemp_c")
    val maxtempC: Double,
    @SerialName("maxtemp_f")
    val maxtempF: Double,
    @SerialName("mintemp_c")
    val mintempC: Double,
    @SerialName("mintemp_f")
    val mintempF: Double,
    @SerialName("condition")
    val condition: Condition,
)

@Serializable
data class Hour(
    @SerialName("time_epoch")
    val timeEpoch: Long,
    @SerialName("time")
    val time: String,
    @SerialName("temp_c")
    val tempC: Double,
    @SerialName("temp_f")
    val tempF: Double,
    @SerialName("is_day")
    val isDay: Int,
    @SerialName("condition")
    val condition: Condition,
)