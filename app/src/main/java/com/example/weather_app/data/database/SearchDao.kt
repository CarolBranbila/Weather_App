package com.example.weather_app.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

interface SearchDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(search: List<SearchEntity>)

    @Delete
    suspend fun delete(search: SearchEntity)

    @Query("SELECT * FROM SearchEntity")
    suspend fun getAll(): List<SearchEntity>
    //fndByName
}