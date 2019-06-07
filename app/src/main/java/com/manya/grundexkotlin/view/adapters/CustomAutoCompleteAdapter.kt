package com.manya.grundexkotlin.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.manya.grundexkotlin.viewModel.CalculatingCostViewModel

class CustomAutoCompleteAdapter<T>(private val context: Context, private val type : Int) : BaseAdapter(), Filterable{

    private var model : CalculatingCostViewModel? = null

    private var list: List<T>? = ArrayList()

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getItem(position: Int): T? {
        return list?.get(position)
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

        val t = getItem(position)
        (view?.findViewById<TextView>(android.R.id.text1))?.text = t.toString()

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults? {
                val filterResults = FilterResults()
                    if (constraint != null) {
                        model?.find(constraint as String, type)
                    }
                filterResults.values = list
                filterResults.count = count
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results.count > 0) {
                    list = results.values as List<T>?
                } else {
                    notifyDataSetInvalidated()
                }
            }
        }
    }

    fun setList(list : List<T>) {
        this.list = list
    }

    fun setModel(model : CalculatingCostViewModel){
        this.model = model
    }
}