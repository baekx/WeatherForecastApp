package com.example.weatherforecastapp.data.repository

import com.example.weatherforecastapp.data.remote.ImageApi
import com.example.weatherforecastapp.data.remote.dto.image.ImageResponseDto
import com.example.weatherforecastapp.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: ImageApi
) : ImageRepository {
    override suspend fun getImageUrl(cityName: String): ImageResponseDto {
        return api.getImageList(cityName)
    }
}
