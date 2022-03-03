package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.StaticTextFragmentsWithYellowBackgroundBinding

class PlacementOverViewFragment : Fragment() {
    private lateinit var binding: StaticTextFragmentsWithYellowBackgroundBinding
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
        binding.pageTitle = "Placement Overview"
        binding.pageDesc = getString(R.string.placement_overview_p)
    }
}