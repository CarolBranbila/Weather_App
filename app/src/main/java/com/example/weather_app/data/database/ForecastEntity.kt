package com.example.weather_app.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class ForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val forecastDayId: Long,
    val date: String,
    val dateEpoch: Long,

    // Day forecast
    val maxtempC: Double,
    val mintempC: Double,
    val time: String,
    val tempC: Double,
    val isDay: Int,
    val localtime: String,
    val conditionText: String,
    val conditionIcon: String,
    val conditionCode: Int,


)
