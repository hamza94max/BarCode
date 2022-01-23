package com.hamza.barcode.ui.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.R
import com.hamza.barcode.data.DataSet.Dataset
import com.hamza.barcode.data.DataSet.Util
import com.hamza.barcode.databinding.FragmentHomeBinding
import com.hamza.barcode.ui.Adapters.BarCodeAdapter
import com.hamza.barcode.ui.ViewModels.BarcodeViewmodel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewmodel by viewModels<BarcodeViewmodel>()
    private val adapter by lazy { BarCodeAdapter(arrayListOf()) }

    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            val newBarcode = Dataset.SearchforBarcode(result.contents)

            if (newBarcode != null) {

                newBarcode.expiredDays =
                    Util.getexpiredDaysforItem(newBarcode.ExpireDate.toString())

                Toast.makeText(
                    context,
                    "added : " + newBarcode.itemName.toString(),
                    Toast.LENGTH_SHORT
                ).show()

                newBarcode.let { viewmodel.insertItem(it) }
            } else {
                Toast.makeText(context, "Not found in dataBase ! ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentHomeBinding =
            DataBindingUtil.setContentView(context as Activity, R.layout.fragment_home)

        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = adapter

        //viewmodel.insertItem(BarCodeContent(554,"21459577","Milk",ItemType.Drinks.toString(), "1/26/2022",3))

        viewmodel.getNonexpiredItems.observe(viewLifecycleOwner) {
            adapter.updateDataSet(it)
        }

        binding.CaptureNewBarcode.setOnClickListener {
            resultScan.launch(ScanOptions())
        }

    }
}


