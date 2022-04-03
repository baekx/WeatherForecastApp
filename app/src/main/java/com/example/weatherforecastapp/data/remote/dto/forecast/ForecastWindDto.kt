package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.common.roundToString
import com.example.weatherforecastapp.domain.model.forecast.ForecastWind
import com.google.gson.annotations.SerializedName

data class ForecastWindDto(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("gust")
    val gust: Double
)

fun ForecastWindDto.toForecastWind(): ForecastWind {
    return ForecastWind(
        speed = speed.roundToString()
    )
}
