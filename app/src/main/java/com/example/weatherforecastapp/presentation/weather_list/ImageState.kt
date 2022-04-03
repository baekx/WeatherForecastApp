package com.example.weatherforecastapp.presentation.weather_list

import com.example.weatherforecastapp.domain.model.image.ImageResponse


data class ImageState(
    val isLoading: Boolean = false,
    val imageResponse: ImageResponse? = null,
    val error: String = ""
)
