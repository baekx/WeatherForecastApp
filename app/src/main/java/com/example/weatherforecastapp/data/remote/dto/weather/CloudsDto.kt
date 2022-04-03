package com.example.weatherforecastapp.data.remote.dto.weather


import com.example.weatherforecastapp.domain.model.weather.Clouds
import com.google.gson.annotations.SerializedName

data class CloudsDto(
    @SerializedName("all")
    val all: Int
)

fun CloudsDto.toClouds(): Clouds {
    return Clouds(
        cloudity = all
    )
}
