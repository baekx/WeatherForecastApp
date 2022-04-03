package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture

@Composable
fun ShikokuItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Magenta
    val space = 5.dp
    val maxWidth = 110.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp

    Row(modifier = modifier) {
        Column {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Ehime,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.height(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Kochi,
                backgroundColor = color,
                height = height,
                width = width
            )
        }

        Spacer(modifier = Modifier.width(space))

        Column {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Kagawa,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.height(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Tokushima,
                backgroundColor = color,
                height = height,
                width = width
            )
        }
    }
}
