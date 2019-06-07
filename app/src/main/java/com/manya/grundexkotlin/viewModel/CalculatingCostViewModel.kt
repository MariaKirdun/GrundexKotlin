package com.manya.grundexkotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.UserRepository
import com.manya.grundexkotlin.repository.network.OrderCalucation
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

    private val goodsMutable = MutableLiveData<List<Goods>>()
    val goodsLiveData : LiveData<List<Goods>> get() = goodsMutable

    private val costMutableLiveData = MutableLiveData<String>()
    val costLiveData : LiveData<String> get() = costMutableLiveData

    fun find(subString: String, type : Int){
        scope.launch {
            when(type) {
                CITY ->  citiesMutable.postValue(UserRepository.findCities(subString))
                GOODS -> goodsMutable.postValue(UserRepository.findGoods(subString))
            }
        }
    }

    fun calculate (order : OrderCalucation) {
        scope.launch {
            costMutableLiveData.postValue(UserRepository.calculateCost(order))
        }
    }



    companion object {
        const val CITY = 1
        const val GOODS = 2
    }
}