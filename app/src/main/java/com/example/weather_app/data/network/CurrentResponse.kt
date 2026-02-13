package com.example.weather_app.data.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("location")
    val location: Location,
    @SerialName("current")
    val current: Current
)

@Serializable
data class LocationCurrent(
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
data class Current(
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
data class Condition(
    @SerialName("text")
    val text: String,
    @SerialName("icon")
    val icon: String,
    @SerialName("code")
    val code: Int
)