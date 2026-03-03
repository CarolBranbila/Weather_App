package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.asImage
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import com.example.weather_app.R
import com.example.weather_app.feature.CurrentWeather.presentation.CurrentWeatherViewModel
import com.example.weather_app.feature.CurrentWeather.presentation.CurrentWeatherViewState
import com.example.weather_app.feature.CurrentWeather.presentation.TimePerHour
import com.example.weather_app.ui.theme.PreviewAppTheme


@Composable
fun TimePerHourList(
    modifier: Modifier = Modifier,
    hourList: List<TimePerHour> = emptyList(),
    viewState: CurrentWeatherViewState,
){
    LazyRow(
        modifier = modifier
            .padding(8.dp)
    ) {
        items(
            items = viewState.list,
            key = null,
        ){
            HourWeatherIcon(
                modifier = modifier,
                localtime = it.localTime,
                conditionIcon = it.conditionIcon,
                tempC = it.tempC,
            )
        }
    }
}








@Composable
fun HourWeatherIcon(
    modifier: Modifier = Modifier,
    localtime: String,
    conditionIcon: String,
    tempC: String,

){
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = localtime,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displayLarge,
        )
        AsyncImage(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            model = conditionIcon,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Crop    ,
        )
        Text(
            text = tempC,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.displayLarge,
        )
    }
}


@PreviewLightDark
@Composable
fun HourWeatherIconPreview(){
    PreviewAppTheme {
        val bitmap = ImageBitmap.imageResource(R.drawable.weather_preview_example)
        val previewHandler = AsyncImagePreviewHandler {
            bitmap.asAndroidBitmap().asImage()
        }
        CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
            HourWeatherIcon(
                modifier = Modifier,
                localtime = "1PM",
                tempC = "35°",
                conditionIcon = "http://cdn.weatherapi.com/weather/64x64/day/356.png",
            )
        }
    }
}

