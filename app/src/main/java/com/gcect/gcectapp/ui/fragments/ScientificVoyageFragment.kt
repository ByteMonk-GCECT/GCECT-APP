package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.FragmentScientificVoyageBinding
import com.gcect.gcectapp.viewmodels.ScientificVoyageViewModel
import android.content.Intent
import android.net.Uri


class ScientificVoyageFragment : Fragment() {
    private lateinit var binding:FragmentScientificVoyageBinding
    private val viewModel:ScientificVoyageViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_scientific_voyage, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.svFragment = this
    }

    fun openScientificVoyageWebsite(){
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(viewModel.scientificVoyageUrl)
        startActivity(i)
    }
}