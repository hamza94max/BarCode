package com.hamza.barcode.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hamza.barcode.Models.BarCodeContent
import com.hamza.barcode.R

class BarCodeAdapter(private val mList: List<BarCodeContent>) :
    RecyclerView.Adapter<BarCodeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.itemName.text = ItemsViewModel.itemName
        holder.itemType.text = ItemsViewModel.itemtype
        holder.itemExpireDate.text = ItemsViewModel.ExpireDate

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemType: TextView = itemView.findViewById(R.id.item_type)
        val itemExpireDate: TextView = itemView.findViewById(R.id.item_expireDate)

    }
}