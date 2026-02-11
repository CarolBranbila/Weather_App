package com.example.weather_app.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao

interface ForecastDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(currency: List<ForecastDao>)

    @Delete
    suspend fun delete(currency: ForecastEntity)

    @Query("SELECT * FROM ForecastEntity")
    suspend fun getAll(): List<ForecastEntity>
}