package com.manya.grundexkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.City
import com.manya.grundexkotlin.repository.Goods

class CalculatingCostViewModel : ViewModel(){

    private val citiesMutable = MutableLiveData<List<City>>()
    val citiesLiveData : LiveData<List<City>> get() = citiesMutable

    fun findCities(subString : String){

    }

    private val goodsMutable = MutableLiveData<List<Goods>>()
    val goodsLiveData : LiveData<List<Goods>> get() = goodsMutable

    fun findGoods(subString: String){

    }
}