package com.hamza.barcode.ui.Fragments.ExpiredItemsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.barcode.R
import com.hamza.barcode.databinding.FragmentExpiredItemsBinding
import com.hamza.barcode.ui.BarcodeViewModel

class ExpiredItemsFragment : Fragment(R.layout.fragment_expired_items) {

    private var _binding: FragmentExpiredItemsBinding? = null
    private val binding get() = _binding!!

    private val expiredItemsViewModel by viewModels<BarcodeViewModel>()
    private lateinit var expiredItemsAdapter: ExpiredItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExpiredItemsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        observeToLiveData()

    }

    private fun initRecyclerView() {
        binding.expiredRecyclerview.apply {
            expiredItemsAdapter = ExpiredItemsAdapter()
            layoutManager = LinearLayoutManager(context)
            adapter = expiredItemsAdapter
        }
    }

    private fun observeToLiveData() {
        expiredItemsViewModel.getExpiredItems.observe(viewLifecycleOwner) { expiredItems ->
            expiredItemsAdapter.differ.submitList(expiredItems.asReversed())
        }
    }

}
