package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dc.demo.databinding.SingleItemLayoutBinding
import com.dc.demo.models.ChildItem

class SingleItemAdapter() : ListAdapter<ChildItem, SingleItemAdapter.SingleItemViewHolder>(object :
    DiffUtil.ItemCallback<ChildItem>() {
    override fun areItemsTheSame(oldItem: ChildItem, newItem: ChildItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ChildItem, newItem: ChildItem): Boolean {
        return oldItem == newItem
    }
}) {

    inner class SingleItemViewHolder(private val binding: SingleItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: ChildItem) {
            binding.textView.text = item.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemViewHolder {
        return SingleItemViewHolder(
            SingleItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SingleItemViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}