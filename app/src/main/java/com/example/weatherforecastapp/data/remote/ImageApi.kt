package com.example.weatherforecastapp.data.remote

import com.example.weatherforecastapp.data.remote.dto.image.ImageResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("/api")
    suspend fun getImageList(
        @Query(value = "q") keyword: String,
        @Query(value = "key") key: String = "25166773-609922b3d9b24d08d3da9e806"
    ): ImageResponseDto
}
