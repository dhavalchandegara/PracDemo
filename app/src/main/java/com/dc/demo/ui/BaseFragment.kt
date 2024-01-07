package com.dc.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    val TAG: String = this::class.java.simpleName

    abstract fun getLayoutId(): Int

    lateinit var binding: T

    open fun onViewSetup() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
            binding.lifecycleOwner = this
            onViewSetup()
        }
        return binding.root
    }
}