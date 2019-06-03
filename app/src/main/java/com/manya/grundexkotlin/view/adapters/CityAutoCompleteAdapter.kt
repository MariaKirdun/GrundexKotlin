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
import com.manya.grundexkotlin.repository.UserRepository

class CityAutoCompleteAdapter(private val context: Context) : BaseAdapter(), Filterable{

    private var cities: List<City>? = null

    override fun getCount(): Int {
        return cities!!.size
    }

    override fun getItem(position: Int): City {
        return cities!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            convertView = layoutInflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        }

        val city = getItem(position)
        (convertView!!.findViewById<View>(android.R.id.text1) as TextView).text = city.toString()

        return convertView
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                if (constraint != null) {
                    UserRepository.findCities(constraint as String)
                    filterResults.values = cities
                    filterResults.count = cities?.size ?: 0
                }
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results.count > 0) {
                    cities = results.values as List<City>
                    notifyDataSetChanged()
                } else {
                    notifyDataSetInvalidated()
                }
            }
        }
    }

    fun setCities(cities : List<City>) {
        this.cities = cities
    }

}