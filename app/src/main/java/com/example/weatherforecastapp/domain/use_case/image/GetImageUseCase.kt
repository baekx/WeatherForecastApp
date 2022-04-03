package com.example.weatherforecastapp.domain.use_case.image

import com.example.weatherforecastapp.common.Resources
import com.example.weatherforecastapp.data.remote.dto.image.toImageResponse
import com.example.weatherforecastapp.domain.model.image.ImageResponse
import com.example.weatherforecastapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(cityName: String): Flow<Resources<ImageResponse>> = flow {
        try {
            emit(Resources.Loading<ImageResponse>())
            val image = repository.getImageUrl(cityName).toImageResponse()
            emit(Resources.Success<ImageResponse>(image))
        } catch (e: HttpException) {
            emit(Resources.Error<ImageResponse>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resources.Error<ImageResponse>("Couldn't reach server."))
        }
    }
}
