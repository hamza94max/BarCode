package com.hamza.barcode.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.Adapters.BarCodeAdapter
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.R
import com.hamza.barcode.databinding.FragmentHomeBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentHomeBinding =
            DataBindingUtil.setContentView(context as Activity, R.layout.fragment_home)

        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        val data = ArrayList<BarCodeContent>()

        for (i in 1..5) {
            data.add(BarCodeContent(i, "item name $i", "type $i", "2020/6/8"))
        }

        val adapter = BarCodeAdapter(data)

        binding.recyclerview.adapter = adapter


        binding.CaptureNewBarcode.setOnClickListener {
            val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()


                    // TODO : add type of product and name of item

                    // TODO date
                    /* compare the date of barcode with the current day

                    if the date of barcode after current day -> add to home recyclerview with the number of still days
                    else if date of barcode before currrnt day  -> add it to expired products + date of expired
                    else Add as "This product has no expire date "
                     */


                }
            }

            resultScan.launch(ScanOptions())
        }

    }
}
