package com.example.weather_app.data.database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun providesAppDatabase(
        @ApplicationContext context: Context,
    ): AppDataBase = createRoomDatabaseInstance(context)

    @Provides
    fun provideCurrentDao(
        appDataBase: AppDataBase
    ): CurrentDao = appDataBase.currentDao()

    @Provides
    fun provideForecastDao(
        appDataBase: AppDataBase
    ): ForecastDao = appDataBase.forecastDao()
}