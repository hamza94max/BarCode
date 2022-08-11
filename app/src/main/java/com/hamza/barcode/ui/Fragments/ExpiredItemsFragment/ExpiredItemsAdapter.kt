package com.hamza.barcode.ui.Fragments.ExpiredItemsFragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamza.barcode.data.Models.BarCodeItem
import com.hamza.barcode.databinding.ItemsBinding

class ExpiredItemsAdapter : RecyclerView.Adapter<ExpiredItemsAdapter.ExpiredViewHolder>() {

    inner class ExpiredViewHolder(val binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<BarCodeItem>() {
        override fun areItemsTheSame(oldItem: BarCodeItem, newItem: BarCodeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BarCodeItem, newItem: BarCodeItem): Boolean {
            return oldItem == newItem
        }
    }

    var differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpiredViewHolder {

        val view = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpiredViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExpiredViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.binding.itemName.text = currentItem.itemName
        holder.binding.itemType.text = currentItem.itemtype
        holder.binding.itemExpireDate.text = currentItem.expireDate
        holder.binding.itemExpiredDays.text =
            "Expired " + currentItem.expiredDays.toString() + " days"
        holder.binding.itemExpiredDays.setTextColor(Color.RED)


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}