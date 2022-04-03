package com.example.weatherforecastapp.presentation.bottom_navigation

import androidx.annotation.DrawableRes
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.ui.Screen

sealed class BottomNavItem(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
) {
    object WeatherList : BottomNavItem("お天気一覧", R.drawable.ic_list, Screen.WeatherListScreen.route)
    object WeatherMap : BottomNavItem("全国のお天気", R.drawable.ic_map, Screen.WeatherMapScreen.route)
}
