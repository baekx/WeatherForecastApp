package com.example.weatherforecastapp.di

import android.content.Context
import com.example.weatherforecastapp.common.Constants
import com.example.weatherforecastapp.data.remote.ImageApi
import com.example.weatherforecastapp.data.remote.OpenWeatherApi
import com.example.weatherforecastapp.data.repository.ImageRepositoryImpl
import com.example.weatherforecastapp.data.repository.WeatherRepositoryImpl
import com.example.weatherforecastapp.domain.repository.ImageRepository
import com.example.weatherforecastapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOpenWeatherApi(
        okHttpClient: OkHttpClient
    ): OpenWeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.WEATHER_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(OpenWeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: OpenWeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Provides
    fun provideOkHttp(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.HEADERS
                }
            )
            .build()
    }


    @Provides
    @Singleton
    fun provideImageApi(
        okHttpClient: OkHttpClient
    ): ImageApi {
        return Retrofit.Builder()
            .baseUrl(Constants.IMAGE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ImageApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(api: ImageApi): ImageRepository {
        return ImageRepositoryImpl(api)
    }
}
