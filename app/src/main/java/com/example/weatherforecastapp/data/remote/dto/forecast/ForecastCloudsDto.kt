package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.domain.model.forecast.ForecastClouds
import com.google.gson.annotations.SerializedName

data class ForecastCloudsDto(
    @SerializedName("all")
    val all: Int
)

fun ForecastCloudsDto.toForecastClouds(): ForecastClouds {
    return ForecastClouds(
        all = all.toString()
    )
}
