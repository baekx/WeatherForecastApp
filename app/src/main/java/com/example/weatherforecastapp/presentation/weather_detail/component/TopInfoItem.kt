package com.example.weatherforecastapp.presentation.weather_detail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TopInfoItem(
    data: String,
    description: String
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        modifier = Modifier
            .requiredWidth(80.dp)
    ) {
        Column(
            Modifier.padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = description,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data,
                fontSize = 16.sp,
            )
        }
    }
}
