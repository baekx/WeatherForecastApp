package com.example.weatherforecastapp.data.remote.dto.image


import com.example.weatherforecastapp.domain.model.image.ImageResponse
import com.google.gson.annotations.SerializedName

data class ImageResponseDto(
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int,
    @SerializedName("hits")
    val hits: List<Hit>
)

fun ImageResponseDto.toImageResponse(): ImageResponse {
    return ImageResponse(
        imageUrl = hits.random().webformatURL
    )
}
