package com.example.weatherforecastapp.domain.model.forecast

data class Forecast(
    val cod: String,
    val list: List<ForecastList>,
    val cityInfo: CityInfo
)
