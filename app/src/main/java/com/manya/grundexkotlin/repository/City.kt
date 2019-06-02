package com.manya.grundexkotlin.repository

import androidx.annotation.Keep

@Keep
data class City (
    val cityID: String,
    val cityName: String,
    val districtName: String,
    val regionID: String,
    val regionName: String,
    val days: String
)