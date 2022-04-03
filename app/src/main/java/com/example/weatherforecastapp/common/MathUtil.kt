package com.example.weatherforecastapp.common

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

fun Double.roundToString(): String {
    val rounded = (this * 10.0).roundToInt() / 10.0
    return rounded.toString()
}

fun Long.toDateString(pattern: String): String {
    val zonedDateTime = ZonedDateTime.ofInstant(
        Instant.ofEpochSecond(this),
        ZoneId.systemDefault()
    )

    val formatter = DateTimeFormatter.ofPattern(pattern)
    return zonedDateTime.format(formatter)
}
