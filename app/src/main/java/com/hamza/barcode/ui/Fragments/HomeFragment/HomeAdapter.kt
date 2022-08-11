package com.hamza.barcode.ui.Fragments.HomeFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamza.barcode.data.Models.BarCodeItem
import com.hamza.barcode.databinding.ItemsBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<BarCodeItem>() {
        override fun areItemsTheSame(oldItem: BarCodeItem, newItem: BarCodeItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BarCodeItem, newItem: BarCodeItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    var differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val view = ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        holder.binding.itemName.text = currentItem.itemName
        holder.binding.itemType.text = currentItem.itemtype
        holder.binding.itemExpireDate.text = currentItem.expireDate
        holder.binding.itemExpiredDays.text = currentItem.expiredDays.toString() + " days"

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}