package com.example.weather_app.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.weather_app.data.network.Current

interface CurrentDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(current: List<CurrentEntity>)

    @Delete
    suspend fun delete(current: CurrentEntity)

    @Query("SELECT * FROM CurrentEntity")
    suspend fun getAll(): List<CurrentEntity>
}