package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.common.Constants
import com.example.weatherforecastapp.common.toDateString
import com.example.weatherforecastapp.domain.model.forecast.CityInfo
import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("country")
    val country: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("sunrise")
    val sunrise: Long,
    @SerializedName("sunset")
    val sunset: Long
)

fun CityDto.toCityInfo(): CityInfo {
    return CityInfo(
        id = id,
        name = name,
        population = population.toString(),
        sunrise = sunrise.toDateString(Constants.FORMATTER_PATTERN_DATE),
        sunset = sunset.toDateString(Constants.FORMATTER_PATTERN_DATE)
    )
}
