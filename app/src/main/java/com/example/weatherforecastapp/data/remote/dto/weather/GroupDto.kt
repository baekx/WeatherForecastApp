package com.example.weatherforecastapp.data.remote.dto.weather


import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("list")
    val list: List<WeatherDto>
)
