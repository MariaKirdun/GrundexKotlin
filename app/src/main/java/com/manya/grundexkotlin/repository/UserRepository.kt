package com.manya.grundexkotlin.repository

import com.manya.grundexkotlin.repository.network.NetworkingAPI
import com.manya.grundexkotlin.repository.network.TrackingOrderRequest
import com.manya.grundexkotlin.repository.objects.City
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.manya.grundexkotlin.repository.network.AutoCompleteRequest
import com.manya.grundexkotlin.repository.network.OrderCalucation
import com.manya.grundexkotlin.repository.objects.Goods

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
            .getCitiesAsync(AutoCompleteRequest(subString))
            .await()
        return json.body()
    }

    suspend fun findGoods(subString: String) : List<Goods>?{
        val json = retrofit
            .getGoodsAsync(AutoCompleteRequest(subString))
            .await()
        return json.body()
    }

    suspend fun calculateCost(order : OrderCalucation) : String?{
        val cost = retrofit
            .getCostAsync(order)
            .await()
        return cost.body()
    }
}