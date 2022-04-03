package com.example.weatherforecastapp.presentation.weather_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.domain.model.forecast.ForecastList

@Composable
fun HourlyForecastItem(
    forecast: ForecastList
) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = forecast.dt,
            fontSize = 12.sp,
            color = Color.Black
        )
        Image(
            painter = rememberImagePainter("https://openweathermap.org/img/wn/${forecast.forecastWeatherInfo.icon}@2x.png"),
            contentDescription = null,
            modifier = Modifier
                .width(48.dp)
                .height(48.dp)
        )
        Text(
            text = stringResource(R.string.temperature, forecast.main.tempMax),
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}
