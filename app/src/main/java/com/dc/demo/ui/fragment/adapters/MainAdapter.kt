package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.dc.demo.databinding.ItemMainLayoutBinding
import com.dc.demo.models.BoutiqueCollectionItem
import com.dc.demo.models.Data
import com.dc.demo.models.DesignOccasionItem
import com.dc.demo.models.MainStickyMenuItem
import com.dc.demo.models.RangeOfPatternItem
import com.dc.demo.models.ShopByCategoryItem
import com.dc.demo.models.ShopByFabricItem
import com.dc.demo.models.UnstitchedItem

class MainAdapter() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val mainList = ArrayList<Data>()

    fun updateData(list: List<Data>) {
        mainList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        return MainViewHolder(
            ItemMainLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bindData(mainList[position])
    }

    inner class MainViewHolder(private val binding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Data) {
            if (!data.data.isNullOrEmpty()) {
                val any = data.data?.get(0)
                when (any) {
                    is MainStickyMenuItem -> {
                        binding.title.isVisible = false
                        binding.rcy.isVisible = true
                        binding.viewPager.isVisible = false
                        val list = ArrayList(data.data as List<MainStickyMenuItem>?)

                        binding.rcy.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
                        binding.rcy.adapter = MainPagerAdapter(list)
                    }

                    is ShopByFabricItem, is RangeOfPatternItem -> {
                        binding.title.isVisible = true
                        binding.title.text =
                            if (any is ShopByFabricItem) "Shop By Fabric" else "Range Of Pattern"
                        val list =
                            ArrayList(if (any is ShopByFabricItem) data.data as List<ShopByFabricItem>? else data.data as List<RangeOfPatternItem>?)
                        binding.rcy.layoutManager = GridLayoutManager(
                            binding.root.context,
                            2,
                            GridLayoutManager.HORIZONTAL,
                            false
                        )
                        binding.rcy.adapter = SquareAdapter(list)
                        binding.rcy.isVisible = true
                        binding.viewPager.isVisible = false
                    }

                    is ShopByCategoryItem, is DesignOccasionItem -> {
                        binding.title.isVisible = true
                        binding.rcy.isVisible = true
                        binding.viewPager.isVisible = false
                        binding.title.text =
                            if (any is ShopByCategoryItem) "Shop By Category" else "Design As Per Occasion"
                        val list =
                            ArrayList(if (any is ShopByCategoryItem) data.data as List<ShopByCategoryItem>? else data.data as List<DesignOccasionItem>?)
                        binding.rcy.layoutManager = GridLayoutManager(
                            binding.root.context,
                            2,
                            GridLayoutManager.HORIZONTAL,
                            false
                        )
                        binding.rcy.adapter = SquareAdapter(list)
                    }

                    is UnstitchedItem, is BoutiqueCollectionItem -> {
                        binding.title.isVisible = true
                        binding.title.text =
                            if (any is UnstitchedItem) "Unstitched" else "Boutique Collection"
                        val list = ArrayList(if (any is UnstitchedItem) data.data as List<UnstitchedItem>? else data.data as List<BoutiqueCollectionItem>?)
                        binding.rcy.isVisible = false
                        binding.viewPager.isVisible = true

                        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                        binding.viewPager.adapter = AutoSliderAdapter(list)
                    }

                }
            }
        }
    }
}