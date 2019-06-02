package com.manya.grundexkotlin.repository

import androidx.annotation.Keep

@Keep
data class Goods (
    val id: String,
    val name: String,
    val coefficient: String
)