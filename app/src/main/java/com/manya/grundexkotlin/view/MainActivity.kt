package com.manya.grundexkotlin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.manya.grundexkotlin.R
import com.manya.grundexkotlin.view.listeners.CalculatingShipingCostListener
import com.manya.grundexkotlin.view.listeners.SingInAccountButtonClickListener
import com.manya.grundexkotlin.view.listeners.SingInListener
import com.manya.grundexkotlin.view.listeners.TrackingOrderButtonClickListener

class MainActivity : AppCompatActivity(),
    SingInAccountButtonClickListener, TrackingOrderButtonClickListener,
    CalculatingShipingCostListener, SingInListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainFragment())
                .commit()
        }
    }

    override fun singInAcoount() {
        replaceFragment(SingInAccountFragment())
    }

    override fun trackOrder() {
        replaceFragment(TrackingOrderFragment())
    }

    override fun calculateShipingCost() {
        replaceFragment(CalculatingCostFragment())
    }

    override fun singIn() {
        replaceFragment(UserAccountFragment())
    }

    private fun replaceFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
