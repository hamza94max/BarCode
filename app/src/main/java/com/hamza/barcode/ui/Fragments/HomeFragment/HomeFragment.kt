package com.hamza.barcode.ui.Fragments.HomeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.R
import com.hamza.barcode.Utils.Util.getExpiredDaysforItem
import com.hamza.barcode.data.DataSet.FakeDataset
import com.hamza.barcode.databinding.FragmentHomeBinding
import com.hamza.barcode.ui.BarcodeViewModel
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val barcodeViewModel by viewModels<BarcodeViewModel>()
    private lateinit var homeadapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeToLiveData()

        binding.CaptureNewBarcode.setOnClickListener {
            resultScan.launch(ScanOptions())
        }

    }

    private fun setUpRecyclerView() {
        binding.recyclerview.apply {
            homeadapter = HomeAdapter()
            layoutManager = LinearLayoutManager(context)
            adapter = homeadapter
        }
    }

    private fun observeToLiveData() {
        barcodeViewModel.getNonExpiredItems.observe(viewLifecycleOwner) { items ->
            homeadapter.differ.submitList(items.asReversed())
        }
    }


    private val resultScan = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents == null) {
            Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
        } else {
            val newBarcode = FakeDataset.searchForBarcode(result.contents)

            if (newBarcode != null) {

                newBarcode.expiredDays =
                    getExpiredDaysforItem(newBarcode.expireDate)

                Toast.makeText(
                    context,
                    "added : " + newBarcode.itemName,
                    Toast.LENGTH_SHORT
                ).show()

                newBarcode.let { barcodeViewModel.insertItem(it) }
            } else {
                Toast.makeText(context, "Not found in dataBase ! ", Toast.LENGTH_SHORT).show()
            }
        }
    }

}


