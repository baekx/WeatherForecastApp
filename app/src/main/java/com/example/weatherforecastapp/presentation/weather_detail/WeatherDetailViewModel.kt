package com.example.weatherforecastapp.presentation.weather_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.common.Constants
import com.example.weatherforecastapp.common.Resources
import com.example.weatherforecastapp.domain.use_case.image.GetImageUseCase
import com.example.weatherforecastapp.domain.use_case.weather_detail.GetWeatherDetailUseCase
import com.example.weatherforecastapp.presentation.weather_list.ImageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val getWeatherDetailUseCase: GetWeatherDetailUseCase,
    private val getImageUseCase: GetImageUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(WeatherDetailState())
    val state: State<WeatherDetailState> = _state

    private val _imageState = mutableStateOf(ImageState())
    val imageState: State<ImageState> = _imageState

    init {
        savedStateHandle.get<String>(Constants.PARAM_CITY_ID)?.let { cityId ->
            getWeatherDetail(cityId)
        }
        savedStateHandle.get<String>(Constants.PARAM_CITY_NAME)?.let { cityName ->
            getImage(cityName)
        }
    }

    private fun getWeatherDetail(cityId: String) {
        getWeatherDetailUseCase(cityId).onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _state.value = WeatherDetailState(weatherDetail = result.data)
                }
                is Resources.Error -> {
                    _state.value = WeatherDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resources.Loading -> {
                    _state.value = WeatherDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getImage(cityName: String) {
        getImageUseCase(cityName).onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _imageState.value = ImageState(
                        imageResponse = result.data
                    )
                }
                is Resources.Error -> {
                    _imageState.value = ImageState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resources.Loading -> {
                    _imageState.value = ImageState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
