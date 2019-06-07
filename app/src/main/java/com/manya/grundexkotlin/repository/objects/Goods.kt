package com.manya.grundexkotlin.repository.objects

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Goods (
    @SerializedName("ID")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("MarginCoefficient")
    val coefficient: String
) {
    override fun toString(): String {
        return this.name
    }

}