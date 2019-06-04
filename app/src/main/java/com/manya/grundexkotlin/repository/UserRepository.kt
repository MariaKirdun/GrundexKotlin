package com.manya.grundexkotlin.repository

import com.manya.grundexkotlin.repository.network.NetworkingAPI
import com.manya.grundexkotlin.repository.network.TrackingOrderRequest
import com.manya.grundexkotlin.repository.objects.City
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.manya.grundexkotlin.repository.network.CityAutoCompleteRequest

object UserRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://grundex.by/home/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(NetworkingAPI::class.java)

    suspend fun checkOrderStatus(id : String) : String{
        var status  = ""
        val json = retrofit
            .getOrderStatusAsync(TrackingOrderRequest(id))
            .await()
       val order = json.body()
       if (order != null){
           status = order.status
           }
        return status
    }

    suspend fun findCities(subString: String) : List<City>?{
        val json = retrofit
            .getCitiesAsync(CityAutoCompleteRequest(subString))
            .await()
        return json.body()
    }

}