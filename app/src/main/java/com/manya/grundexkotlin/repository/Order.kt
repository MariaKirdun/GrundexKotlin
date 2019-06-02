package com.manya.grundexkotlin.repository

import android.support.annotation.Keep

@Keep
data class Order (
    val id : String,
    val status : String
)