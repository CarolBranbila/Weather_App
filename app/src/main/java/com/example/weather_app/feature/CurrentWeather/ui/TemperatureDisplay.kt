package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.annotation.ExperimentalCoilApi
import coil3.asImage
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import com.example.weather_app.R
import com.example.weather_app.ui.theme.PreviewAppTheme
import androidx.compose.ui.res.imageResource


@Composable
fun MainTemperatureDisplay(
    modifier: Modifier,
    conditionIcon: String,
    conditionText: String,
    maxTempC: String,
    minTemC: String,
    tempC: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        AsyncImage(
            modifier = Modifier
                .width(80.dp)
                .height(100.dp),
            model = conditionIcon,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Crop    ,
        )
        Text(
            text ="$tempC°",
            fontSize = 120.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(start = 16.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = conditionText,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "L: $minTemC°",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = "H: $maxTempC°",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}

@PreviewLightDark
@OptIn(ExperimentalCoilApi::class)
@Composable
private fun MainTemperatureDisplayPreview() {
    PreviewAppTheme {
        val bitmap = ImageBitmap.imageResource(R.drawable.weather_preview_example)
        val previewHandler = AsyncImagePreviewHandler {
            bitmap.asAndroidBitmap().asImage()
        }

        CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
            MainTemperatureDisplay(
                modifier = Modifier,
                conditionText = "Chuvendo pra cacete",
                maxTempC = "12",
                minTemC = "11",
                tempC = "10",
                conditionIcon = "http://cdn.weatherapi.com/weather/64x64/day/356.png",
            )
        }
    }
}