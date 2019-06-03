package com.manya.grundexkotlin.repository.network

import com.manya.grundexkotlin.repository.objects.Order
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkingAPI {

    @POST("getstatus")
    fun getOrderStatus (@Body request : TrackingOrderRequest) : Response<Order>

}