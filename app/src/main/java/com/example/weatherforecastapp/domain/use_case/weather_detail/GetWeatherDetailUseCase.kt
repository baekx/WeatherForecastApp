package com.example.weatherforecastapp.domain.use_case.weather_detail

import com.example.weatherforecastapp.common.Resources
import com.example.weatherforecastapp.data.remote.dto.forecast.toForecast
import com.example.weatherforecastapp.domain.model.forecast.Forecast
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetWeatherDetailUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(cityId: String): Flow<Resources<Forecast>> = flow {
        try {
            emit(Resources.Loading<Forecast>())
            val forecast = repository.getWeatherDetail(cityId)
            emit(Resources.Success<Forecast>(forecast.toForecast()))
        } catch (e: HttpException) {
            emit(Resources.Error<Forecast>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error<Forecast>("Couldn't reach server."))
        }
    }
}
