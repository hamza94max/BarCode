package com.hamza.barcode.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmodel by viewModels<BarcodeViewmodel>()
    private val adapter by lazy { BarCodeAdapter(arrayListOf()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = adapter

        viewmodel.getNonexpiredItems.observe(viewLifecycleOwner) {
            adapter.updateDataSet(it)
        }

        binding.CaptureNewBarcode.setOnClickListener {
            resultScan.launch(ScanOptions())
        }

    }


    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            val newBarcode = Dataset.SearchforBarcode(result.contents)

            if (newBarcode != null) {

                newBarcode.expiredDays =
                    Util.getExpiredDaysforItem(newBarcode.ExpireDate)

                Toast.makeText(
                    context,
                    "added : " + newBarcode.itemName,
                    Toast.LENGTH_SHORT
                ).show()

                newBarcode.let { viewmodel.insertItem(it) }
            } else {
                Toast.makeText(context, "Not found in dataBase ! ", Toast.LENGTH_SHORT).show()
            }
        }
    }


}


