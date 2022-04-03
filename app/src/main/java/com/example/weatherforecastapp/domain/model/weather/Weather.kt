package com.example.weatherforecastapp.domain.model.weather

data class Weather(
    val weather: WeatherInfo,
    val main: Main,
    val cloudity: Clouds,
    val dateTime: Int,
    val cityId: String,
    val name: String
)
