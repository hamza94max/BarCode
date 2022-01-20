package com.hamza.barcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.Adapters.BarCodeAdapter
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<BarCodeContent>()

        for (i in 1..5) {
            data.add(BarCodeContent(i, "item name " + i, "type " + i, "2020/6/8"))
        }

        val adapter = BarCodeAdapter(data)

        binding.recyclerview.adapter = adapter


    }
}