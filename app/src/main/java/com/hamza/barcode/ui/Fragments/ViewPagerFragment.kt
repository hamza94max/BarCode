package com.hamza.barcode.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hamza.barcode.R
import com.hamza.barcode.databinding.FragmentViewPagerBinding
import com.hamza.barcode.ui.Adapters.ViewPagerAdapter


class ViewPagerFragment : Fragment() {


    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)

        val fragments = listOf(
            HomeFragment(),
            ExpiredItemsFragment(),
        )

        val adapter =
            ViewPagerAdapter(fragments, childFragmentManager, viewLifecycleOwner.lifecycle)

        binding.viewPager.adapter = adapter


        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.home).uppercase()
                1 -> tab.text = getString(R.string.expired_products).uppercase()
            }
        }.attach()

        return binding.root
    }
}