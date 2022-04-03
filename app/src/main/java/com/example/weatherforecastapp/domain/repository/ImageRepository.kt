package com.example.weatherforecastapp.domain.repository

import com.example.weatherforecastapp.data.remote.dto.image.ImageResponseDto

interface ImageRepository {
    suspend fun getImageUrl(cityName: String): ImageResponseDto
}
