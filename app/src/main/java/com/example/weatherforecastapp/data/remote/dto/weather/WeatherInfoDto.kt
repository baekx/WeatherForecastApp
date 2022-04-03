package com.example.weatherforecastapp.data.remote.dto.weather


import com.example.weatherforecastapp.domain.model.weather.WeatherInfo
import com.google.gson.annotations.SerializedName

data class WeatherInfoDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)

fun WeatherInfoDto.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        id = id,
        description = description,
        icon = icon
    )
}
