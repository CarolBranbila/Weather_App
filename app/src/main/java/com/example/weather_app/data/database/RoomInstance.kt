package com.example.weather_app.data.database

import android.content.Context
import androidx.room.Room
import kotlin.jvm.java

fun createRoomDatabaseInstance(
    applicationContext: Context
): AppDataBase =
    Room.databaseBuilder(
        applicationContext,
        AppDataBase::class.java,
        "btg.db",
    ).build()