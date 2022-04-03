package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture

@Composable
fun KyushuItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Gray
    val space = 5.dp
    val maxWidth = 110.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp
    val maxHeight = height * 2 + space

    Column(modifier = modifier, horizontalAlignment = Alignment.End) {
        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Nagasaki,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Saga,
                backgroundColor = color,
                height = height,
                width = width
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Fukuoka,
                backgroundColor = color,
                height = height,
                width = width
            )
        }

        Spacer(modifier = Modifier.height(space))

        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Kumamoto,
                backgroundColor = color,
                height = maxHeight,
                width = width
            )
            Spacer(modifier = Modifier.width(space))

            Column {
                PrefectureItem(
                    navController = navController,
                    prefecture = Prefecture.Oita,
                    backgroundColor = color,
                    height = height,
                    width = width
                )
                Spacer(modifier = Modifier.height(space))
                PrefectureItem(
                    navController = navController,
                    prefecture = Prefecture.Miyazaki,
                    backgroundColor = color,
                    height = height,
                    width = width
                )
            }
        }

        Spacer(modifier = Modifier.height(space))

        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Kagoshima,
            backgroundColor = color,
            height = height,
            width = maxWidth
        )
    }
}
