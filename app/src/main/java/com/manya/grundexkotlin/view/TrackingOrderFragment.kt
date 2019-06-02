package com.manya.grundexkotlin.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        trackButton.setOnClickListener {
            val trackId = orderIDEditText.text.toString()
            if (trackId != "") {
                model.checkStatus(trackId)
                orderStatus.text = model.orderStatusLiveData.value
            } else {
                orderStatus.text = "Empty input"
            }
        }

    }

}