package com.example.weatherforecastapp.domain.repository

import com.example.weatherforecastapp.data.remote.dto.forecast.ForecastDto
import com.example.weatherforecastapp.data.remote.dto.weather.GroupDto

interface WeatherRepository {
    suspend fun getWeatherList(cityIds: String): GroupDto
    suspend fun getWeatherDetail(cityId: String): ForecastDto
}
