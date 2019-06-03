package com.manya.grundexkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Goods

class CalculatingCostViewModel : ViewModel(){

    private val citiesMutable = MutableLiveData<List<City>>()
    val citiesLiveData : LiveData<List<City>> get() = citiesMutable


    private val goodsMutable = MutableLiveData<List<Goods>>()
    val goodsLiveData : LiveData<List<Goods>> get() = goodsMutable

    fun findGoods(subString: String){

    }
}