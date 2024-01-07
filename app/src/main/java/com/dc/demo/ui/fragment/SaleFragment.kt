package com.dc.demo.ui.fragment

import com.dc.demo.R
import com.dc.demo.databinding.FragmentSaleBinding
import com.dc.demo.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaleFragment : BaseFragment<FragmentSaleBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_sale
    }

    override fun onViewSetup() {
        super.onViewSetup()

    }
}