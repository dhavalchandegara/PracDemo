package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dc.demo.databinding.SingleImageLayoutBinding
import com.dc.demo.utility.loadImage

class SliderAdapter(private val list: ArrayList<String> = ArrayList()) :
    RecyclerView.Adapter<SliderAdapter.SlideItemViewHolder>() {

    inner class SlideItemViewHolder(private val binding: SingleImageLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.imageView.loadImage(item)
        }
    }

    fun getSize(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideItemViewHolder {
        return SlideItemViewHolder(
            SingleImageLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SlideItemViewHolder, position: Int) {
        holder.bind(list[position])
    }
}