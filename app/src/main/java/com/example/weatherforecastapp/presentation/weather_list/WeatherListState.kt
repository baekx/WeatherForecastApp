package com.example.weatherforecastapp.presentation.weather_list

import com.example.weatherforecastapp.domain.model.weather.Weather

data class WeatherListState(
    val isLoading: Boolean = false,
    val weatherList: List<Weather> = emptyList(),
    val error: String = ""
)
