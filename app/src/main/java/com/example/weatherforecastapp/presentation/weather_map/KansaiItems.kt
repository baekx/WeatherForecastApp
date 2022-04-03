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
fun KansaiItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Red
    val space = 5.dp
    val maxWidth = 110.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp
    val maxHeight = height * 2 + space

    Column(modifier = modifier) {
        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Hyogo,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Kyoto,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Shiga,
                backgroundColor = color,
                height = height,
                width = width
            )
        }

        Spacer(modifier = Modifier.height(space))

        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Osaka,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Nara,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Mie,
                backgroundColor = color,
                height = height,
                width = width
            )
        }

        Spacer(modifier = Modifier.height(space))

        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Wakayama,
            backgroundColor = color,
            height = height,
            width = maxWidth
        )
    }
}
