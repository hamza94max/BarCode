package com.hamza.barcode.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hamza.barcode.R


class ExpiredItemsFragment : Fragment(R.layout.fragment_expired_items) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        Toast.makeText(context, "Here 2", Toast.LENGTH_LONG).show()
    }

}