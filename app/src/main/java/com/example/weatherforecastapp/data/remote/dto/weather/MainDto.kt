package com.example.weatherforecastapp.data.remote.dto.weather


import com.example.weatherforecastapp.common.roundToString
import com.example.weatherforecastapp.domain.model.weather.Main
import com.google.gson.annotations.SerializedName

data class MainDto(
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("grnd_level")
    val grndLevel: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
)

fun MainDto.toMain(): Main {
    return Main(
        temp = temp,
        tempMin = tempMin.roundToString(),
        tempMax = tempMax.roundToString(),
        humidity = humidity.toString()
    )
}
