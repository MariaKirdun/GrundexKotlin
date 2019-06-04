package com.manya.grundexkotlin.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.manya.grundexkotlin.R
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.view.adapters.CityAutoCompleteAdapter
import com.manya.grundexkotlin.viewModel.CalculatingCostViewModel
import kotlinx.android.synthetic.main.calculate_cost_activity.*

class CalculatingCostFragment : Fragment(){

    private lateinit var model : CalculatingCostViewModel
    private val cityAutoCompleteAdapter = this.context?.let { CityAutoCompleteAdapter(it) }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        model = ViewModelProviders.of(this).get(CalculatingCostViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.calculate_cost_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityAutoCompleteAdapter?.setModel(model)
        model.citiesLiveData.observe(this, Observer {
            cityAutoCompleteAdapter?.setCities(it)
        })

        cityAutoCompleteTextView.threshold = 2
        cityAutoCompleteTextView.setAdapter(cityAutoCompleteAdapter)
        cityAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                    val city = parent.getItemAtPosition(position) as City
                    cityAutoCompleteTextView.setText(city.toString())
            }
      //  productAutoCompleteTextView.setThreshold(2)
       // productAutoCompleteTextView.setAdapter(GoodsAutoCompleteAdapter(this))
        //productAutoCompleteTextView.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
          //  val goods = parent.getItemAtPosition(position) as Goods
            //productAutoCompleteTextView.setText(goods.toString())
        //})

    }

}