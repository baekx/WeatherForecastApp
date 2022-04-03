package com.example.weatherforecastapp.domain.use_case.weather_list

import com.example.weatherforecastapp.common.Resources
import com.example.weatherforecastapp.data.remote.dto.weather.toWeather
import com.example.weatherforecastapp.domain.model.weather.Weather
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherListUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(id: String): Flow<Resources<List<Weather>>> = flow {
        try {
            emit(Resources.Loading<List<Weather>>())
            val weathers = repository.getWeatherList(id).list.map { it.toWeather() }
            emit(Resources.Success<List<Weather>>(weathers))
        } catch (e: HttpException) {
            emit(Resources.Error<List<Weather>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error<List<Weather>>("Couldn't reach server."))
        }
    }
}
