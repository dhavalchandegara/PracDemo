package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dc.demo.databinding.SquareItemLayoutBinding
import com.dc.demo.models.DesignOccasionItem
import com.dc.demo.models.RangeOfPatternItem
import com.dc.demo.models.ShopByCategoryItem
import com.dc.demo.models.ShopByFabricItem
import com.dc.demo.utility.circleLoadImage
import com.dc.demo.utility.loadImage

class SquareAdapter(private val arrayList: ArrayList<Any> = ArrayList()) : RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        return SquareViewHolder(
            SquareItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        holder.bindData(arrayList[position])
    }

    inner class SquareViewHolder(private val binding: SquareItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Any) {
            if (item is DesignOccasionItem) {
                binding.imageView.loadImage(item.image.orEmpty())
                binding.textView.text = item.name
            } else if (item is ShopByCategoryItem) {
                binding.imageView.loadImage(item.image.orEmpty())
                binding.textView.text = item.name
            } else if (item is ShopByFabricItem) {
                binding.imageView.circleLoadImage(item.image.orEmpty())
                binding.textView.text = item.name
            } else if (item is RangeOfPatternItem) {
                binding.imageView.circleLoadImage(item.image.orEmpty())
                binding.textView.text = item.name
            }
        }
    }
}