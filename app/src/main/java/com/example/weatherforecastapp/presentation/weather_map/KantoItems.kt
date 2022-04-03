package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture

@Composable
fun KantoItems(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
//    val backgroundColor = Color.Green
    val height = 40.dp
    val width = 110.dp
    val space = 5.dp

    Column(modifier = modifier) {
        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Gunma,
                backgroundColor = color,
                height = height,
                width = (width - space) / 2
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Tochigi,
                backgroundColor = color,
                height = height,
                width = (width - space) / 2
            )
        }

        Spacer(modifier = Modifier.height(space))

        Row {
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Saitama,
                backgroundColor = color,
                height = height,
                width = (width - space) / 2
            )
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Ibaraki,
                backgroundColor = color,
                height = height,
                width = (width - space) / 2
            )
        }

        Spacer(modifier = Modifier.height(space))

        Row {
            Column {
                PrefectureItem(
                    navController = navController,
                    prefecture = Prefecture.Tokyo,
                    backgroundColor = color,
                    height = height,
                    width = (width - space) / 2
                )
                Spacer(modifier = Modifier.height(space))
                PrefectureItem(
                    navController = navController,
                    prefecture = Prefecture.Kanagawa,
                    backgroundColor = color,
                    height = height,
                    width = (width - space) / 2
                )
            }
            Spacer(modifier = Modifier.width(space))
            PrefectureItem(
                navController = navController,
                prefecture = Prefecture.Chiba,
                backgroundColor = color,
                height = height * 2 + space,
                width = (width - space) / 2
            )
        }
    }
}
