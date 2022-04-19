package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.AdministrationUiBinding

class AdministrationFragment: Fragment() {
    lateinit var binding:AdministrationUiBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.administration_ui, container, false)
        return binding.root
    }
}