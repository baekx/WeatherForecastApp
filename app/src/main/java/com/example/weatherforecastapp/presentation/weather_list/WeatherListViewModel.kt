package com.example.weatherforecastapp.presentation.weather_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.common.Resources
import com.example.weatherforecastapp.common.createCityIdString
import com.example.weatherforecastapp.domain.use_case.image.GetImageUseCase
import com.example.weatherforecastapp.domain.use_case.weather_list.GetWeatherListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val getWeatherListUseCase: GetWeatherListUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(WeatherListState())
    val state: State<WeatherListState> = _state

    init {
        getWeatherList()
    }

    private fun getWeatherList() {
        getWeatherListUseCase(createCityIdString()).onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _state.value = WeatherListState(
                        weatherList = result.data ?: emptyList()
                    )
                }
                is Resources.Error -> {
                    _state.value = WeatherListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resources.Loading -> {
                    _state.value = WeatherListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
