package com.example.weatherforecastapp.data.remote

import com.example.weatherforecastapp.data.remote.dto.forecast.ForecastDto
import com.example.weatherforecastapp.data.remote.dto.weather.GroupDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("/data/2.5/group")
    suspend fun getWeatherList(
        @Query(value = "id") id: String,
        @Query(value = "units") units: String = "metric",
        @Query(value = "lang") lang: String = "ja",
        @Query(value = "appid") appid: String = "74681d456ce80e4e524da29a5fceac9f"
    ): GroupDto

    @GET("/data/2.5/forecast")
    suspend fun getWeatherDetail(
        @Query(value = "id") id: String,
        @Query(value = "units") units: String = "metric",
        @Query(value = "lang") lang: String = "ja",
        @Query(value = "appid") appid: String = "74681d456ce80e4e524da29a5fceac9f"
    ): ForecastDto
}
