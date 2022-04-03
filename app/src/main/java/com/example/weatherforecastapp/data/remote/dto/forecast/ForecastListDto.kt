package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.common.Constants
import com.example.weatherforecastapp.common.toDateString
import com.example.weatherforecastapp.domain.model.forecast.ForecastList
import com.google.gson.annotations.SerializedName

data class ForecastListDto(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("main")
    val forecastMainDto: ForecastMainDto,
    @SerializedName("weather")
    val forecastWeatherDto: List<ForecastWeatherDto>,
    @SerializedName("clouds")
    val forecastCloudsDto: ForecastCloudsDto,
    @SerializedName("wind")
    val forecastWindDto: ForecastWindDto,
    @SerializedName("visibility")
    val visibility: Int,
//    @SerializedName("pop")
//    val pop: Int,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("dt_txt")
    val dtTxt: String,
    @SerializedName("snow")
    val snow: Snow,
    @SerializedName("rain")
    val rain: Rain
)

fun ForecastListDto.toForecastList(): ForecastList {
    return ForecastList(
        dt = dt.toDateString(Constants.FORMATTER_PATTERN_HOUR),
        main = forecastMainDto.toForecastMain(),
        forecastWeatherInfo = forecastWeatherDto.first().toForecastWeatherInfo(),
        forecastClouds = forecastCloudsDto.toForecastClouds(),
        forecastWind = forecastWindDto.toForecastWind()
    )
}
