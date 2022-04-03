package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture
import com.example.weatherforecastapp.ui.Screen

@Composable
fun PrefectureItem(
    navController: NavController,
    prefecture: Prefecture,
    backgroundColor: Color,
    height: Dp,
    width: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(color = backgroundColor)
                .height(height)
                .width(width)
                .clickable { navigateWeatherDetail(navController, prefecture) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = prefecture.cityName,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

fun navigateWeatherDetail(navController: NavController, prefecture: Prefecture) {
    navController.navigate(
        Screen.WeatherDetailScreen.route + "/${prefecture.cityId}" + "/${prefecture.cityName}"
    )
}
