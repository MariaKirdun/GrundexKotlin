package com.manya.grundexkotlin.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manya.grundexkotlin.R
import com.manya.grundexkotlin.view.listeners.SingInListener
import kotlinx.android.synthetic.main.sing_in_layout.*

class SingInAccountFragment : Fragment(){

    private var singInListener : SingInListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SingInListener){
            singInListener = context
        } else {
            throw RuntimeException("Host activity must implement CounterClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sing_in_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        singInButton?.setOnClickListener {
            singInListener?.singIn()
        }
    }

}