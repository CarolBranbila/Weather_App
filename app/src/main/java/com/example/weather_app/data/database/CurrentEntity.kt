package com.example.weather_app.data.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @Embedded val location: CurrentLocationEntity,
    // Current Weather
    val tempC: Double,
    val conditionText: String,
    val conditionIcon: String,
    val conditionCode: Int,
)

data class CurrentLocationEntity(
    val localName: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val localtime: String,
)
