package com.example.weather_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        CurrentEntity::class,
        ForecastEntity::class,
        SearchEntity::class
    ],
    version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun currentDao(): CurrentDao
    abstract fun forecastDao(): ForecastDao
    abstract fun searchDao(): SearchDao
}