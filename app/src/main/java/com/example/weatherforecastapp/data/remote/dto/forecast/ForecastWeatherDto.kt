package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.domain.model.forecast.ForecastWeatherInfo
import com.google.gson.annotations.SerializedName

data class ForecastWeatherDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)

fun ForecastWeatherDto.toForecastWeatherInfo(): ForecastWeatherInfo {
    return ForecastWeatherInfo(
        id = id,
        description = description,
        icon = icon
    )
}
