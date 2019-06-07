package com.manya.grundexkotlin.repository.network

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class OrderCalucation (
    @SerializedName("Id")
    private val id : String,
    @SerializedName("RegionId")
    private val regionId : String,
    @SerializedName("Num")
    private val num : String,
    @SerializedName("Coef")
    private val coefficient : String
)