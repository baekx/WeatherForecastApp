package com.example.weatherforecastapp.data.remote.dto.weather


import com.example.weatherforecastapp.domain.model.weather.Weather
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("clouds")
    val cloudsDto: CloudsDto,
    @SerializedName("coord")
    val coordDto: CoordDto,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val mainDto: MainDto,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val sysDto: SysDto,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weatherInfoDto: List<WeatherInfoDto>,
    @SerializedName("wind")
    val windDto: WindDto
)

fun WeatherDto.toWeather(): Weather {
    return Weather(
        weather = weatherInfoDto.first().toWeatherInfo(),
        main = mainDto.toMain(),
        cloudity = cloudsDto.toClouds(),
        dateTime = dt,
        cityId = id.toString(),
        name = name
    )
}
