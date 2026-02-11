package com.example.weather_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        CurrentEntity::class,
        //QuotesEntity::class
    ],
    version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun currentDao(): CurrentDao
    abstract fun forecastDao(): ForecastDao
}