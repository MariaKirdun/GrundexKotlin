package com.manya.grundexkotlin.repository

import android.support.annotation.Keep

@Keep
data class Goods (
    val id: String,
    val name: String,
    val coefficient: String
)