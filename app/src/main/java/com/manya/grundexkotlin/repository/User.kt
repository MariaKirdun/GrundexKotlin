package com.manya.grundexkotlin.repository

import androidx.annotation.Keep

@Keep
data class User(
    val number : Int,
    val login : String,
    val eMail : String,
    val discount : Int
)