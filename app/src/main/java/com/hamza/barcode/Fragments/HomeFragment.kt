package com.hamza.barcode.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.Adapters.BarCodeAdapter
import com.hamza.barcode.DataSet.ItemType
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.R
import com.hamza.barcode.ViewModel.BarcodeViewmodel
import com.hamza.barcode.databinding.FragmentHomeBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(context, "Not found in database !", Toast.LENGTH_LONG).show()
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


    private val viewmodel by viewModels<BarcodeViewmodel>()
    private val adapter by lazy { BarCodeAdapter(arrayListOf()) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentHomeBinding =
            DataBindingUtil.setContentView(context as Activity, R.layout.fragment_home)

        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = adapter

        val barCodeContent = BarCodeContent(
            5, "554 6849",
            "Milk", ItemType.Drinks.toString(), "2021/2/15", false
        )

        viewmodel.insertItem(barCodeContent)



        viewmodel.getItems.observe(viewLifecycleOwner) {
            adapter.updateDataSet(it)
        }


        binding.CaptureNewBarcode.setOnClickListener {
            resultScan.launch(ScanOptions())
        }


    }
    }



