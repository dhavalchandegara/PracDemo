package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dc.demo.databinding.ItemViewPagerLauoutBinding
import com.dc.demo.models.BoutiqueCollectionItem
import com.dc.demo.models.UnstitchedItem
import com.dc.demo.utility.loadImage

class AutoSliderAdapter(private val arrayList: ArrayList<Any> = ArrayList()) :
    RecyclerView.Adapter<AutoSliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(private val binding: ItemViewPagerLauoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Any) {
            if (item is UnstitchedItem) {
                binding.imageview.loadImage(item.image.orEmpty())
                binding.textview.text = item.name
                binding.textview2.text = item.description
            } else if (item is BoutiqueCollectionItem) {
                binding.imageview.loadImage(item.bannerImage.orEmpty())
                binding.textview.text = item.name
                binding.textview2.text = item.cta
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            ItemViewPagerLauoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bindData(arrayList[position])
    }
}