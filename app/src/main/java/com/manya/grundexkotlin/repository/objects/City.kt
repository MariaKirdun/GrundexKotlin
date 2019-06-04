package com.manya.grundexkotlin.repository.objects

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class City (
    @SerializedName("CityId")
    val cityID: String,
    @SerializedName("CityName")
    val cityName: String,
    @SerializedName("DistrictName")
    val districtName: String,
    @SerializedName("RegionId")
    val regionID: String,
    @SerializedName("RegionName")
    val regionName: String,
    @SerializedName("Days")
    val days: String
) {
    override fun toString(): String {
        return this.cityName + ", " +
                this.districtName + "р-н, " +
                this.regionName + "обл."
    }
}