package com.manya.grundexkotlin.repository.objects

import androidx.annotation.Keep

@Keep
data class Goods (
    val id: String,
    val name: String,
    val coefficient: String
)