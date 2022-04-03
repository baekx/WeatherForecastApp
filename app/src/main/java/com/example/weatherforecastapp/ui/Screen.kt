package com.example.weatherforecastapp.ui

sealed class Screen(val route: String) {
    object WeatherListScreen: Screen("weather_list_screen")
    object WeatherMapScreen: Screen("weather_map_screen")
    object WeatherDetailScreen: Screen("weather_detail_screen")
}
