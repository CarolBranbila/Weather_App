package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.ui.theme.PreviewAppTheme

@Composable
fun HourWeatherIcon(
    modifier: Modifier = Modifier,
    localtime: String,
    //conditionIcon: String,
    tempC: String,

){
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = localtime,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(start = 16.dp),
        )
        Text(
            text = tempC,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Thin,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(start = 16.dp),
        )
    }
}


@PreviewLightDark
@Composable
fun HourWeatherIconPreview(){
    PreviewAppTheme {
        HourWeatherIcon(
            modifier = Modifier,
            localtime = "1PM",
            tempC = "35°"
        )
    }
}