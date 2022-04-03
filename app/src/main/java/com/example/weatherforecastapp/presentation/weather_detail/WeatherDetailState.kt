package com.example.weatherforecastapp.presentation.weather_detail

import com.example.weatherforecastapp.domain.model.forecast.Forecast

data class WeatherDetailState(
    val isLoading: Boolean = false,
    val weatherDetail: Forecast? = null,
    val error: String = ""
)
