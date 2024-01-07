package com.dc.demo.ui.fragment

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.dc.demo.R
import com.dc.demo.common.Resource
import com.dc.demo.databinding.FragmentHomeBinding
import com.dc.demo.ui.BaseFragment
import com.dc.demo.ui.fragment.adapters.MainAdapter
import com.dc.demo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    private val mainAdapter = MainAdapter()

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewSetup() {
        super.onViewSetup()

        binding.rcyMain.adapter = mainAdapter

        mainViewModel.getHomePageData().observe(this) {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar2.isVisible = true
                }

                is Resource.Success -> {
                    binding.progressBar2.isVisible = false

                    mainAdapter.updateData(it.data.orEmpty())
                }

                is Resource.Failed -> {
                    binding.progressBar2.isVisible = false

                    Toast.makeText(requireContext(), it.message.orEmpty(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}