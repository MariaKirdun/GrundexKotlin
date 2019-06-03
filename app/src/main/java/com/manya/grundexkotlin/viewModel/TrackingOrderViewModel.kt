package com.manya.grundexkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TrackingOrderViewModel : ViewModel(){

    private val orderStatusMutable = MutableLiveData<String>()
    val orderStatusLiveData : LiveData<String> get() =  orderStatusMutable

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    fun checkStatus(id : String){
        scope.launch {
            orderStatusMutable.postValue(UserRepository.checkOrderStatus(id))
        }
    }

}