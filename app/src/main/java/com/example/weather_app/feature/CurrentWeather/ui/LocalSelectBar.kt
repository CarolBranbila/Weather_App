package com.example.weather_app.feature.CurrentWeather.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.weather_app.ui.theme.PreviewAppTheme

@Composable
fun LocalSelect(
    modifier: Modifier,
    localName: String,
    onClick: (() -> Unit)?,
) {
    val clickableModifier = onClick?.let {
        Modifier.clickable(
            onClick = it,
            role = Role.Button,
        )
    } ?: Modifier

    Row(
        modifier = clickableModifier
            .border(
                width = 1.dp,
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.secondaryContainer,
            )
            .padding(vertical = 8.dp)
            .minimumInteractiveComponentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = localName
        )

        onClick?.let {
            Icon(
                modifier = Modifier
                    .padding(end = 16.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "Selecionar local",
                tint = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}


@PreviewLightDark
@Composable
private fun LocalSelectPreview() {
    PreviewAppTheme {
        LocalSelect(
            modifier = Modifier,
            localName = "Lisbon",
            onClick = {},
        )
    }
}