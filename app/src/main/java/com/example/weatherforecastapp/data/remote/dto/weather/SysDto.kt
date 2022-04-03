package com.example.weatherforecastapp.data.remote.dto.weather


import com.google.gson.annotations.SerializedName

data class SysDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int,
    @SerializedName("timezone")
    val timezone: Int
)
