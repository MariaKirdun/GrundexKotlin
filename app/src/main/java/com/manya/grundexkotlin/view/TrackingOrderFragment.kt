package com.manya.grundexkotlin.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manya.grundexkotlin.R
import com.manya.grundexkotlin.viewModel.TrackingOrderViewModel
import kotlinx.android.synthetic.main.tracking_order_layout.*

class TrackingOrderFragment : Fragment(){

    private lateinit var model : TrackingOrderViewModel


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        model = ViewModelProviders.of(this).get(TrackingOrderViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tracking_order_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.orderStatusLiveData.observe(this,  Observer { orderStatus.text = it})

        trackButton.setOnClickListener {
            val trackId = orderIDEditText.text.toString()
            if (trackId != "") {
                model.checkStatus(trackId)
            } else {
                orderStatus.text = EMPTY_INPUT
            }
        }

    }

    companion object {
        private const val EMPTY_INPUT = "Empty Input"
    }

}