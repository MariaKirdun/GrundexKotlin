package com.manya.grundexkotlin.repository.objects

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Order (
    @SerializedName("Status")
    val status : String
)