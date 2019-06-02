package com.manya.grundexkotlin.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manya.grundexkotlin.R
import com.manya.grundexkotlin.view.listeners.CalculatingShipingCostListener
import com.manya.grundexkotlin.view.listeners.SingInAccountButtonClickListener
import com.manya.grundexkotlin.view.listeners.TrackingOrderButtonClickListener
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private var singInListener : SingInAccountButtonClickListener? = null
    private var trackingOrderListener: TrackingOrderButtonClickListener? = null
    private var calculatingShippingCostListener : CalculatingShipingCostListener? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SingInAccountButtonClickListener
            && context is TrackingOrderButtonClickListener
            && context is CalculatingShipingCostListener
        ){
            singInListener = context
            trackingOrderListener = context
            calculatingShippingCostListener = context
        } else {
            throw RuntimeException("Host activity must implement CounterClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        singInKabinetButton?.setOnClickListener {
            singInListener?.singInAcoount()
        }
        trakingOrderButton?.setOnClickListener {
            trackingOrderListener?.trackOrder()
        }
        calculateShippingCostButton?.setOnClickListener {
            calculatingShippingCostListener?.calculateShipingCost()
        }
    }
}