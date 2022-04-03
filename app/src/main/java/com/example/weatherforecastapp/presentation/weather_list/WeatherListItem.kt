package com.example.weatherforecastapp.presentation.weather_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.domain.model.weather.Weather
import com.example.weatherforecastapp.ui.theme.lightGray

@Composable
fun WeatherListItem(
    weather: Weather,
    imageUrl: String,
    onItemClick: (Weather) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(weather) }
            .height(140.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(140.dp)
                .background(color = lightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = "https://openweathermap.org/img/wn/${weather.weather.icon}@2x.png"),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = weather.weather.description,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black, Color.Black),
                            startY = 70f
                        )
                    ),
                alpha = 0.7f
            )

            Row() {
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
                ) {
                    Text(
                        text = weather.name,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxHeight()
                            .requiredWidth(100.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier,
                    ) {
                        Text(
                            text = stringResource(R.string.temperature, weather.main.tempMax),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = stringResource(R.string.divider),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = stringResource(R.string.temperature, weather.main.tempMin),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = stringResource(R.string.humidity, weather.main.humidity),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = stringResource(R.string.cloudity, weather.cloudity.cloudity),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
