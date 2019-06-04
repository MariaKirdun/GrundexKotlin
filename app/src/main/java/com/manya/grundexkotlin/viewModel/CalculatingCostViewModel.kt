package com.manya.grundexkotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.UserRepository
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Goods
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CalculatingCostViewModel : ViewModel(){

    private val scope = CoroutineScope(Dispatchers.IO + Job())

    private val citiesMutable = MutableLiveData<List<City>>()
    val citiesLiveData : LiveData<List<City>> get() = citiesMutable

    fun findCities(subString: String){
        scope.launch {
            citiesMutable.postValue(UserRepository.findCities(subString))
        }
        Log.d("Retrofit", "bla bla")
    }

    private val goodsMutable = MutableLiveData<List<Goods>>()
    val goodsLiveData : LiveData<List<Goods>> get() = goodsMutable


}