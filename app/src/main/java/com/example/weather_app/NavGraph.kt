package com.example.weather_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.HiltViewModelFactory
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.weather_app.feature.CurrentWeather.presentation.CurrentWeatherViewModel
import com.example.weather_app.feature.CurrentWeather.ui.CurrentWeatherScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.Serializable

@Serializable
data object CurrentWeather

@Serializable
data object ForecastWeather

@Composable
fun MainNavGraph(){
    val navController = rememberNavController()
    val currentViewModel = hiltViewModel<CurrentWeatherViewModel>()

    val navGraph = remember(navController){
        navController.createGraph(
            startDestination = CurrentWeather
        ){
            composable<CurrentWeather>{
                CurrentWeatherScreen(
                    modifier = Modifier,
                    viewModel = currentViewModel,
                    onClick1 = {
                        navController.navigate(
                            ForecastWeather
                        )
                    }
                ) { }
            }
        }
    }
    NavHost(
        navController = navController,
        graph = navGraph,
    )
}