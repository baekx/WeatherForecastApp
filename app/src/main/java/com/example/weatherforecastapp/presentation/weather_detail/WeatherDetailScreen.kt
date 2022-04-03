package com.example.weatherforecastapp.presentation.weather_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.presentation.weather_detail.component.HourlyForecastItem
import com.example.weatherforecastapp.presentation.weather_detail.component.TopInfoItem

@Composable
fun WeatherDetailScreen(
    viewModel: WeatherDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.weatherDetail?.let {
            val currentWeather = state.weatherDetail.list.first()
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                ) {
                    Image(
                        painter = rememberImagePainter(data = viewModel.imageState.value.imageResponse?.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = state.weatherDetail.cityInfo.name,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(data = "https://openweathermap.org/img/wn/${currentWeather.forecastWeatherInfo.icon}@2x.png"),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(110.dp)
                                .width(120.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = stringResource(R.string.temperature, currentWeather.main.tempMax),
                            fontSize = 52.sp,
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        items(state.weatherDetail.list.take(7)) { forecast ->
                            HourlyForecastItem(forecast)
                        }
                    }

                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                        ,
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TopInfoItem(
                            data = stringResource(
                                R.string.wind_unit,
                                currentWeather.forecastWind.speed
                            ),
                            description = stringResource(R.string.wind_label)
                        )
                        TopInfoItem(
                            data = stringResource(R.string.temperature, currentWeather.main.feelsLike),
                            description = stringResource(R.string.feel_like_label)
                        )
                        TopInfoItem(
                            data = stringResource(R.string.percent, currentWeather.main.humidity),
                            description = stringResource(R.string.humidity_label)
                        )
                        TopInfoItem(
                            data = stringResource(R.string.percent, currentWeather.forecastClouds.all),
                            description = stringResource(R.string.cloudity)
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(40.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_ei_sunrise),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(
                                    R.string.date,
                                    state.weatherDetail.cityInfo.sunrise
                                ),
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_ei_sunset),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = stringResource(
                                    R.string.date,
                                    state.weatherDetail.cityInfo.sunset
                                ),
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                color = Color.Black
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
