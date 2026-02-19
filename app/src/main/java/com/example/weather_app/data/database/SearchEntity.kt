package com.example.weather_app.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,

    val localName: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val url: String
)
