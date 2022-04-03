package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture

@Composable
fun OkinawaItem(
    navController: NavController,
    color: Color,
    modifier: Modifier = Modifier
) {
    val maxWidth = 110.dp
    val space = 5.dp
    val width = (maxWidth - space) / 2
    val height = 40.dp
    val pxValue = with(LocalDensity.current) { 100.dp.toPx() }
    val lineWidth = with(LocalDensity.current) { 2.dp.toPx() }

    Box(
        modifier = modifier
            .width(100.dp)
            .height(100.dp)
            .background(color = Color.Transparent)
            .drawBehind {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(pxValue, 0f),
                    strokeWidth = lineWidth
                )
                drawLine(
                    color = Color.Gray,
                    start = Offset(pxValue, 0f),
                    end = Offset(pxValue, pxValue),
                    strokeWidth = lineWidth
                )
            }
        ,
        contentAlignment = Alignment.Center
    ) {
        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.Okinawa,
            backgroundColor = color,
            height = height,
            width = width
        )
    }
}
