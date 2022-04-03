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
fun ChubuWestItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.LightGray
    val space = 5.dp
    val maxWidth = 110.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp
    val maxHeight = height * 2 + space

    Column(modifier = modifier) {
        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Ishikawa,
            backgroundColor = color,
            height = height,
            width = width
        )
        Spacer(modifier = Modifier.height(space))
        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Fukui,
            backgroundColor = color,
            height = height,
            width = width
        )
    }
}
