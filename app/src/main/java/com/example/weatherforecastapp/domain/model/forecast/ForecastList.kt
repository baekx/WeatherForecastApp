package com.example.weatherforecastapp.domain.model.forecast

data class ForecastList(
    val dt: String,
    val main: ForecastMain,
    val forecastWeatherInfo: ForecastWeatherInfo,
    val forecastClouds: ForecastClouds,
    val forecastWind: ForecastWind
)
