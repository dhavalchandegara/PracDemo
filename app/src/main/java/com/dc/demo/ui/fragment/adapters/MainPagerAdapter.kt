package com.dc.demo.ui.fragment.adapters

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dc.demo.databinding.MainAdapterLayoutBinding
import com.dc.demo.models.MainStickyMenuItem

class MainPagerAdapter(private val arrayList: ArrayList<MainStickyMenuItem> = ArrayList()) :
    RecyclerView.Adapter<MainPagerAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val binding: MainAdapterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: MainStickyMenuItem) {
            binding.textview.text = item.title
            binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            val stringList = ArrayList(item.sliderImages.orEmpty().map { it?.image.orEmpty() })
            val sliderAdapter = SliderAdapter(stringList)
            binding.viewPager.adapter = sliderAdapter

            object : CountDownTimer(Long.MAX_VALUE, 3000) {
                override fun onTick(millisUntilFinished: Long) {
                    if (binding.viewPager.currentItem < (sliderAdapter.getSize() - 1)) {
                        binding.viewPager.currentItem += 1
                    } else {
                        binding.viewPager.currentItem = 0
                    }
                }

                override fun onFinish() {
                }

            }.start()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            MainAdapterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(arrayList[position])
    }
}

