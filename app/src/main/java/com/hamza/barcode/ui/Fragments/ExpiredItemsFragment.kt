package com.hamza.barcode.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.R
import com.hamza.barcode.databinding.FragmentExpiredItemsBinding
import com.hamza.barcode.ui.Adapters.ExpiredItemsAdapter
import com.hamza.barcode.ui.ViewModels.BarcodeViewmodel

class ExpiredItemsFragment : Fragment(R.layout.fragment_expired_items) {

    private var _binding: FragmentExpiredItemsBinding? = null
    private val binding get() = _binding!!

    private val expiredItemsViewmodel by viewModels<BarcodeViewmodel>()
    private val adapter by lazy { ExpiredItemsAdapter(arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExpiredItemsBinding.inflate(layoutInflater, container, false)
        binding.expiredRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.expiredRecyclerview.adapter = adapter

        expiredItemsViewmodel.getexpiredItems.observe(viewLifecycleOwner) {
            adapter.updateDataSet(it)
        }
        return super.onCreateView(inflater, container, savedInstanceState)

    }

}