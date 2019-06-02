package com.manya.grundexkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.UserRepository

class TrackingOrderViewModel : ViewModel(){

    private val orderStatusMutable = MutableLiveData<String>()
    val orderStatusLiveData : LiveData<String> get() =  orderStatusMutable


    fun checkStatus(id : String){
        orderStatusMutable.postValue(UserRepository.getOrderStatus(id))
    }

}