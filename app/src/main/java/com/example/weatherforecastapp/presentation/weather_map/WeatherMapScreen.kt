package com.example.weatherforecastapp.presentation.weather_map

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.weatherforecastapp.common.Prefecture
import com.example.weatherforecastapp.ui.Screen
import com.example.weatherforecastapp.ui.theme.*

@Composable
fun WeatherMapScreen(
    navController: NavController
) {
    val state = rememberScrollState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(state)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, main)
                ),
                alpha = 0.6f
            )
    ) {
        val (
            hokkaido, tohoku, kanto, chubu, chubuWest,
            kansai, chugoku, shikoku, kyushu, okinawa
        ) = createRefs()

        PrefectureItem(
            navController = navController,
            prefecture = Prefecture.HOKKAIDO,
            backgroundColor = main,
            height = 80.dp,
            width = 110.dp,
            modifier = Modifier
                .constrainAs(hokkaido) {
                    top.linkTo(parent.top,40.dp)
                    end.linkTo(parent.end, 10.dp)
                }
        )

        TohokuItems(
            navController = navController,
            color = mainRed,
            modifier = Modifier.constrainAs(tohoku) {
                top.linkTo(hokkaido.bottom, 5.dp)
                end.linkTo(parent.end, 10.dp)
            }
        )

        KantoItems(
            navController = navController,
            color = mainGreen,
            modifier = Modifier.constrainAs(kanto) {
                top.linkTo(tohoku.bottom, 5.dp)
                end.linkTo(parent.end, 10.dp)
            }
        )

        ChubuItems(
            navController = navController,
            color = third,
            modifier = Modifier.constrainAs(chubu) {
                bottom.linkTo(kanto.bottom)
                end.linkTo(kanto.start, 5.dp)
            }
        )

        ChubuWestItems(
            navController = navController,
            color = third,
            modifier = Modifier.constrainAs(chubuWest) {
                top.linkTo(chubu.top)
                end.linkTo(chubu.start, 5.dp)
            }
        )

        KansaiItems(
            navController = navController,
            color = violet,
            modifier = Modifier.constrainAs(kansai) {
                bottom.linkTo(chubu.bottom)
                end.linkTo(chubu.start, 5.dp)
            }
        )

        ChuugokuItems(
            navController = navController,
            color = weakMain,
            modifier = Modifier.constrainAs(chugoku) {
                top.linkTo(kansai.top)
                end.linkTo(kansai.start, 5.dp)
            }
        )

        ShikokuItems(
            navController = navController,
            color = weakGreen,
            modifier = Modifier.constrainAs(shikoku) {
                top.linkTo(chugoku.bottom, 15.dp)
                start.linkTo(chugoku.start)
                end.linkTo(chugoku.end)
            }
        )

        KyushuItems(
            navController = navController,
            color = royalBlue,
            modifier = Modifier.constrainAs(kyushu) {
                top.linkTo(chugoku.top)
                end.linkTo(chugoku.start, 10.dp)
                start.linkTo(parent.start, 10.dp)
            }
        )

        OkinawaItem(
            navController = navController,
            color = mainYellow,
            modifier = Modifier.constrainAs(okinawa) {
                top.linkTo(kyushu.bottom, 40.dp)
                start.linkTo(parent.start, 10.dp)
            }
        )
    }
}

