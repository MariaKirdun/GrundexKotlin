package com.manya.grundexkotlin.repository

import com.manya.grundexkotlin.repository.network.NetworkingAPI
import com.manya.grundexkotlin.repository.network.TrackingOrderRequest
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Order
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

object UserRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://grundex.by/home/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getOrderStatus(id : String): String {

        var status  = ""
        val json = retrofit
            .create(NetworkingAPI::class.java)
            .getOrderStatus(TrackingOrderRequest(id))
        val order = json.body()
        if (order != null){
            status = order.status
        }
        return status
    }

    fun findCities(subString: String) : List<City>?{

        return null
    }

}