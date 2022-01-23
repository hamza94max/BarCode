package com.hamza.barcode.ui.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.R
import com.hamza.barcode.databinding.FragmentExpiredItemsBinding
import com.hamza.barcode.ui.Adapters.ExpiredItemsAdapter
import com.hamza.barcode.ui.ViewModels.BarcodeViewmodel

class ExpiredItemsFragment : Fragment(R.layout.fragment_expired_items) {

    private val expiredItemsViewmodel by viewModels<BarcodeViewmodel>()
    private val adapter by lazy { ExpiredItemsAdapter(arrayListOf()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentExpiredItemsBinding =
            DataBindingUtil.setContentView(context as Activity, R.layout.fragment_expired_items)

        binding.expiredRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.expiredRecyclerview.adapter = adapter

        expiredItemsViewmodel.getexpiredItems.observe(viewLifecycleOwner) {
            adapter.updateDataSet(it)
        }
    }

}