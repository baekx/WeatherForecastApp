package com.example.weatherforecastapp.data.remote.dto.weather


import com.google.gson.annotations.SerializedName

data class WindDto(
    @SerializedName("deg")
    val deg: Int,
    @SerializedName("speed")
    val speed: Double
)
