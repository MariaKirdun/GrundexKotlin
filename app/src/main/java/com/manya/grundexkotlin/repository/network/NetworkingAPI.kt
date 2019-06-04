package com.manya.grundexkotlin.repository.network

import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Order
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkingAPI {

    @POST("getstatus")
    fun getOrderStatusAsync (@Body request : TrackingOrderRequest) : Deferred<Response<Order>>

    @POST("autocompletecity")
    fun getCitiesAsync (@Body request: CityAutoCompleteRequest) : Deferred<Response<List<City>>>

}