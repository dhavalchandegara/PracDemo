package com.dc.demo.ui.fragment

import com.dc.demo.R
import com.dc.demo.databinding.FragmentMoreBinding
import com.dc.demo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoreFragment : BaseFragment<FragmentMoreBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_more
    }

    override fun onViewSetup() {
        super.onViewSetup()

    }
}