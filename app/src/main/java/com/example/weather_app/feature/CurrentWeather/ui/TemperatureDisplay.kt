package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun MainTemperatureDisplay(
    modifier: Modifier,
    //conditionIcon: String,
    conditionText: String,
    maxTempC: String,
    minTemC: String,
    tempC: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = tempC,
            fontSize = 120.sp,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(start = 16.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = conditionText,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = minTemC,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary,
            )
            Text(
                text = maxTempC,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun MainTemperatureDisplayPreview() {
    PreviewAppTheme {
        MainTemperatureDisplay(
            modifier = Modifier,
            conditionText = "Chuvendo pra cacete",
            maxTempC = "12°",
            minTemC = "11°",
            tempC = "10°",
        )
    }
}