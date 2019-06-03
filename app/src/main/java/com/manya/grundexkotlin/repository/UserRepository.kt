package com.manya.grundexkotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manya.grundexkotlin.repository.network.NetworkingAPI
import com.manya.grundexkotlin.repository.network.TrackingOrderRequest
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Order
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

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
            .getOrderStatus(TrackingOrderRequest(id))
            .await()
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