package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture
import com.example.weatherforecastapp.common.Prefecture.*

@Composable
fun TohokuItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Cyan
    val height = 40.dp
    val width = 110.dp
    val verticalSpace = 5.dp
    val horizontalSpace = 5.dp

    Column(modifier = modifier) {
        PrefectureItem(
            navController = navController,
            prefecture = Aomori,
            backgroundColor = color,
            height = height,
            width = width
        )
        
        Spacer(modifier = Modifier.height(verticalSpace))

        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Akita,
                backgroundColor = color,
                height = height,
                width = (width - horizontalSpace) / 2
            )
            Spacer(modifier = Modifier.width(horizontalSpace))
            PrefectureItem(
                navController = navController,
                prefecture = Iwate,
                backgroundColor = color,
                height = height,
                width = (width - horizontalSpace) / 2
            )
        }

        Spacer(modifier = Modifier.height(verticalSpace))

        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Yamagata,
                backgroundColor = color,
                height = height,
                width = (width - horizontalSpace) / 2
            )
            Spacer(modifier = Modifier.width(horizontalSpace))
            PrefectureItem(
                navController = navController,
                prefecture = Miyagi,
                backgroundColor = color,
                height = height,
                width = (width - horizontalSpace) / 2
            )
        }

        Spacer(modifier = Modifier.height(verticalSpace))

        PrefectureItem(
            navController = navController,
            prefecture = Fukushima,
            backgroundColor = color,
            height = height,
            width = width
        )
    }
}
