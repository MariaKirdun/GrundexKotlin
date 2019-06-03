package com.manya.grundexkotlin.repository.network

import com.manya.grundexkotlin.repository.objects.Order
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkingAPI {

    @POST("getstatus")
    fun getOrderStatus (@Body request : TrackingOrderRequest) : Deferred<Response<Order>>

}