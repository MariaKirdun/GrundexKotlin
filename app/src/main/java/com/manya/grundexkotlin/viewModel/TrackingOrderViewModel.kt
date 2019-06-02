package com.manya.grundexkotlin.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.manya.grundexkotlin.repository.UserRepository

class TrackingOrderViewModel : ViewModel(){

    private val orderStatusMutable = MutableLiveData<String>()
    val orderStatusLiveData : LiveData<String> get() =  orderStatusMutable


    fun checkStatus(id : String){
        orderStatusMutable.postValue(UserRepository.getOrderStatus(id))
    }


    class TrackingVMFactory : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

}