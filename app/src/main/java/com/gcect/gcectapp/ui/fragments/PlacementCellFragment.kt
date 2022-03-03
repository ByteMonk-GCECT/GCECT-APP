package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.StaticTextFragmentsWithYellowBackgroundBinding

class PlacementCellFragment : Fragment() {
    private lateinit var binding:StaticTextFragmentsWithYellowBackgroundBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.static_text_fragments_with_yellow_background, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pageTitle = "Placement Cell"
        binding.pageDesc = getString(R.string.placement_cell_p)
        binding.txtExtra.text = "For Correspondance with Training and Placement Cell: gcect@rediffmail.com"
    }
}