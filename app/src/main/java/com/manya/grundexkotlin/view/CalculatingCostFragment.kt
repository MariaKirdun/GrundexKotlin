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
import com.manya.grundexkotlin.repository.network.OrderCalucation
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.repository.objects.Goods
import com.manya.grundexkotlin.view.adapters.CustomAutoCompleteAdapter
import com.manya.grundexkotlin.viewModel.CalculatingCostViewModel
import kotlinx.android.synthetic.main.calculate_cost_activity.*

class CalculatingCostFragment : Fragment(){

    private lateinit var model : CalculatingCostViewModel
    private var cityAutoCompleteAdapter : CustomAutoCompleteAdapter<City>? = null
    private var goodsAutoCompleteAdapter : CustomAutoCompleteAdapter<Goods>? = null

    private var city : City? = null
    private var goods : Goods? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        model = ViewModelProviders.of(this).get(CalculatingCostViewModel::class.java)
        cityAutoCompleteAdapter = this.context?.let { CustomAutoCompleteAdapter(it, CalculatingCostViewModel.CITY) }
        goodsAutoCompleteAdapter = this.context?.let { CustomAutoCompleteAdapter(it, CalculatingCostViewModel.GOODS) }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.calculate_cost_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityAutoCompleteTextView = view.findViewById<DelayAutoCompleteTextView>(R.id.cityAutoCompleteTextView)
        cityAutoCompleteAdapter?.setModel(model)
        cityAutoCompleteTextView.threshold = 1
        cityAutoCompleteTextView.setAdapter(cityAutoCompleteAdapter)
        cityAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                city = parent.getItemAtPosition(position) as City
                cityAutoCompleteTextView.setText(city.toString())
                cityAutoCompleteTextView.isEnabled = false
            }
        model.citiesLiveData.observe(this, Observer {
            cityAutoCompleteAdapter?.setList(it)
            cityAutoCompleteAdapter?.notifyDataSetChanged()
        })

        val productAutoCompleteTextView = view.findViewById<DelayAutoCompleteTextView>(R.id.productAutoCompleteTextView)
        goodsAutoCompleteAdapter?.setModel(model)
        productAutoCompleteTextView.threshold = 1
        productAutoCompleteTextView.setAdapter(goodsAutoCompleteAdapter)
        productAutoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            goods = parent.getItemAtPosition(position) as Goods
            productAutoCompleteTextView.setText(goods.toString())
            productAutoCompleteTextView.isEnabled = false
        }
        model.goodsLiveData.observe(this, Observer {
            goodsAutoCompleteAdapter?.setList(it)
            goodsAutoCompleteAdapter?.notifyDataSetChanged()
        })


        model.costLiveData.observe(this, Observer {
            orderCost.text = it
        })

        calculateButton.setOnClickListener {
                val order =
                    OrderCalucation(
                        goods?.id.toString(), city?.regionID.toString(), quantityEditText.text.toString(),
                        goods?.coefficient.toString()
                    )
                model.calculate(order)
        }

    }

}