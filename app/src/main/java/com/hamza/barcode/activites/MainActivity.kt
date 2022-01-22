package com.hamza.barcode.activites

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hamza.barcode.Fragments.ExpiredItemsFragment
import com.hamza.barcode.Fragments.HomeFragment
import com.hamza.barcode.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = HomeFragment()
        val secondFragment = ExpiredItemsFragment()

        //setCurrentFragment(firstFragment)


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.expire -> setCurrentFragment(secondFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()

            bottomNavigationView.visibility = View.VISIBLE
        }
}