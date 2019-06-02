package com.manya.grundexkotlin.repository

import android.support.annotation.Keep

@Keep
data class User(
    val number : Int,
    val login : String,
    val eMail : String,
    val discount : Int
)