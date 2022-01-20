package com.hamza.barcode.activites

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.Adapters.BarCodeAdapter
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.R
import com.hamza.barcode.databinding.ActivityMainBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

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

    fun capture(view: View) {
        resultScan.launch(ScanOptions())
    }

    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()


            // TODO : add type of product and name of item

            // TODO date
            /* compare the date of barcode with the current day

            if the date of barcode after current day -> add to home recyclerview with the number of still days
            else if date of barcode before currrnt day  -> add it to expired products + date of expired
            else Add as "This product has no expire date "
             */


        }
    }
}