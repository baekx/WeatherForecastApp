package com.example.weatherforecastapp.data.remote.dto.forecast


import com.example.weatherforecastapp.domain.model.forecast.Forecast
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Int,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("list")
    val list: List<ForecastListDto>,
    @SerializedName("city")
    val city: CityDto
)

fun ForecastDto.toForecast(): Forecast {
    return Forecast(
        cod = cod,
        list = list.map { it.toForecastList() },
        cityInfo = city.toCityInfo()
    )
}
