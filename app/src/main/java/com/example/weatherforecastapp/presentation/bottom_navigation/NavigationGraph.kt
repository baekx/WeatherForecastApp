package com.example.weatherforecastapp.presentation.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherforecastapp.common.Constants
import com.example.weatherforecastapp.presentation.weather_detail.WeatherDetailScreen
import com.example.weatherforecastapp.presentation.weather_list.WeatherListScreen
import com.example.weatherforecastapp.presentation.weather_map.WeatherMapScreen
import com.example.weatherforecastapp.ui.Screen

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.WeatherList.route
    ) {
        composable(BottomNavItem.WeatherList.route) {
            WeatherListScreen(navController = navHostController)
        }
        composable(BottomNavItem.WeatherMap.route) {
            WeatherMapScreen(navController = navHostController)
        }
        composable(
            route = Screen.WeatherDetailScreen.route + "/{cityId}" + "/{cityName}"
        ) {
            WeatherDetailScreen()
        }
    }
}
