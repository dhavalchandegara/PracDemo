package com.dc.demo.ui.fragment

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dc.demo.R
import com.dc.demo.common.Resource
import com.dc.demo.databinding.FragmentCategoryBinding
import com.dc.demo.ui.BaseFragment
import com.dc.demo.ui.fragment.adapters.CategoryAdapters
import com.dc.demo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    private val categoryAdapters = CategoryAdapters()

    private val mainViewModel: MainViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.fragment_category
    }

    override fun onViewSetup() {
        super.onViewSetup()

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rcyCategory.adapter = categoryAdapters

        mainViewModel.getCategory().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is Resource.Success -> {
                    binding.progressBar.isVisible = false

                    categoryAdapters.submitList(it.data?.categories)
                }

                is Resource.Failed -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), it.message.orEmpty(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}