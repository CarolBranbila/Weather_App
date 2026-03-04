package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Cottage
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.weather_app.feature.CurrentWeather.presentation.CurrentWeatherViewModel
import com.example.weather_app.feature.CurrentWeather.presentation.CurrentWeatherViewState
import com.example.weather_app.ui.theme.PreviewAppTheme


@Composable
fun CurrentWeatherScreen(
    modifier: Modifier,
    viewModel: CurrentWeatherViewModel,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
){
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = onClick1) {
                        Icon(
                            Icons.Default.Cottage,
                            contentDescription = "Current Weather",
                        )
                    }
                    IconButton(onClick = onClick2) {
                        Icon(
                            Icons.Default.CalendarMonth,
                            contentDescription = "Forecast Weather",
                        )
                    }
                },
                containerColor = MaterialTheme.colorScheme.primary,
            )
        }
    ) { innerPadding ->
        when{
            viewState.isLoading ->
                ScreenLoading(
                    modifier = Modifier
                        .padding(innerPadding)
                )
            viewState.isError ->
                ErrorMessageScreen(
                    message = viewState.errorMessage,
                    onClick = {onClick1} //ajustar depois na viewModel
                )
            else ->{
                ContentCurrentWeatherScreen(
                    modifier = modifier,
                    viewState = viewState,
                )
            }
        }
    }
}

@Composable
fun ContentCurrentWeatherScreen(
    modifier: Modifier,
    viewState: CurrentWeatherViewState,
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        LocalSelect(
            modifier = modifier,
            localName = viewState.localName,
        ) {}

        MainTemperatureDisplay(
            modifier = modifier,
            conditionIcon = viewState.conditionIcon,
            conditionText = viewState.conditionText,
            maxTempC = viewState.maxTempC,
            minTemC = viewState.minTemC,
            tempC = viewState.tempC,
        )
        TimePerHourList(
            modifier = Modifier,
            viewState = viewState
        )
    }
}



@Composable
fun ScreenLoading(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
        )
    }

}

@Composable
fun ErrorMessageScreen(
    message: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Erro",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(64.dp)
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = message,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(32.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClick,
        ) {
            Text(
                text = /*stringResource(R.string.error_button_text)*/"Tente Novamente",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@PreviewLightDark
@Composable
fun ContentCurrentWeatherScreenPreview(){
    PreviewAppTheme {
        ContentCurrentWeatherScreen(
            modifier = Modifier,
            viewState = CurrentWeatherViewState(
                list = emptyList(),
                isLoading = false,
                isError = false,
                errorMessage = "",
                localName = "São Paulo",
                conditionIcon = "",
                conditionText = "Ensolarado",
                maxTempC = "32",
                minTemC = "20",
                tempC = "28"
            )
        )
    }
}




@PreviewLightDark
@Composable
fun ScreenLoadingPreview(){
    PreviewAppTheme { 
        ScreenLoading(
            modifier = Modifier,
        )
    }
}


@PreviewLightDark
@Composable
fun ErrorMessageScreenPreview(){
    PreviewAppTheme {
       ErrorMessageScreen(
           message = "Oops",
           onClick = {}
       ) 
    }

}