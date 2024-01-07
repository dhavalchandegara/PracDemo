package com.dc.demo.ui.fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dc.demo.databinding.ItemMainCategoryBinding
import com.dc.demo.models.CategoriesItem

class CategoryAdapters() :
    ListAdapter<CategoriesItem, CategoryAdapters.CategoryItemViewHolder>(object :
        DiffUtil.ItemCallback<CategoriesItem>() {

        override fun areItemsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoriesItem,
            newItem: CategoriesItem
        ): Boolean {
            return oldItem == newItem
        }

    }) {

    inner class CategoryItemViewHolder(private val binding: ItemMainCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: CategoriesItem) {
            binding.tvMainCate.text = item.categoryName
            binding.frame.setOnClickListener {
                binding.expandable.toggle()
            }
            val itemAdapter = SingleItemAdapter()
            binding.subCate.adapter = itemAdapter
            itemAdapter.submitList(item.child)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(
            ItemMainCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}