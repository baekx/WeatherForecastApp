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
fun ChuugokuItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Yellow
    val space = 5.dp
    val maxWidth = 110.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp
    val maxHeight = height * 2 + space

    Row(modifier = modifier) {
        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Yamaguchi,
            backgroundColor = color,
            height = maxHeight,
            width = width
        )

        Spacer(modifier = Modifier.width(space))

        Column {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Shimane,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.height(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Shimane,
                backgroundColor = color,
                height = height,
                width = width
            )
        }

        Spacer(modifier = Modifier.width(space))

        Column {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Tottori,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.height(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Okayama,
                backgroundColor = color,
                height = height,
                width = width
            )
        }
    }
}
