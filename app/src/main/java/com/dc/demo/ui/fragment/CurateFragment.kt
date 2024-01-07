package com.dc.demo.ui.fragment

import com.dc.demo.R
import com.dc.demo.databinding.FragmentCurateBinding
import com.dc.demo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurateFragment : BaseFragment<FragmentCurateBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_curate
    }

    override fun onViewSetup() {
        super.onViewSetup()

    }
}