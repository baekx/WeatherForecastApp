package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.common.roundToString
import com.example.weatherforecastapp.domain.model.forecast.ForecastMain
import com.google.gson.annotations.SerializedName

data class ForecastMainDto(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("feels_like")
    val feelsLike: Double,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("grnd_level")
    val grndLevel: Int,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp_kf")
    val tempKf: Double
)

fun ForecastMainDto.toForecastMain(): ForecastMain {
    return ForecastMain(
        feelsLike = feelsLike.roundToString(),
        tempMin = tempMin.roundToString(),
        tempMax = tempMax.roundToString(),
        humidity = humidity.toString()
    )
}
