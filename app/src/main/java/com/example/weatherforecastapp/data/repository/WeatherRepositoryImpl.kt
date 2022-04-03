package com.example.weatherforecastapp.data.repository

import com.example.weatherforecastapp.data.remote.OpenWeatherApi
import com.example.weatherforecastapp.data.remote.dto.forecast.ForecastDto
import com.example.weatherforecastapp.data.remote.dto.weather.GroupDto
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: OpenWeatherApi
) : WeatherRepository {
    override suspend fun getWeatherList(cityIds: String): GroupDto {
        return api.getWeatherList(cityIds)
    }

    override suspend fun getWeatherDetail(cityId: String): ForecastDto {
        return api.getWeatherDetail(cityId)
    }
}
