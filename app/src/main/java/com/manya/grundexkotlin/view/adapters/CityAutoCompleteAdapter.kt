package com.manya.grundexkotlin.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.manya.grundexkotlin.repository.objects.City
import com.manya.grundexkotlin.viewModel.CalculatingCostViewModel

class CityAutoCompleteAdapter(private val context: Context) : BaseAdapter(), Filterable{

    private var model : CalculatingCostViewModel? = null

    private var cities: List<City>? = ArrayList()

    override fun getCount(): Int {
        return cities!!.size
    }

    override fun getItem(position: Int): City {
        return cities!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        if (view == null) {
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        }

        val city = getItem(position)
        (view?.findViewById<TextView>(android.R.id.text1))?.text = city.toString()

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint != null) {
                    model?.findCities(constraint as String)
                    filterResults.values = cities
                    filterResults.count = cities?.size!!
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results.count > 0) {
                    cities = results.values as List<City>?
                    notifyDataSetChanged()
                } else {
                    notifyDataSetInvalidated()
                }
            }
        }
    }

    fun setCities(cities : List<City>) {
        this.cities = cities
        notifyDataSetChanged()
    }

    fun setModel(model : CalculatingCostViewModel){
        this.model = model
    }
}