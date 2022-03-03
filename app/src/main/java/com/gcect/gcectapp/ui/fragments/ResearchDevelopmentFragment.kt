package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.ResearchDevelopmentRecyclerAdapter
import com.gcect.gcectapp.databinding.FragmentResearchDevelopmentBinding
import com.gcect.gcectapp.viewmodels.ResearchDevelopmentViewModel


class ResearchDevelopmentFragment : Fragment() {
    private lateinit var binding:FragmentResearchDevelopmentBinding
    private val viewModel:ResearchDevelopmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_research_development, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSetup(binding.rvProjectDetail)
    }

    private fun recyclerViewSetup(recyclerView: RecyclerView) {
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = ResearchDevelopmentRecyclerAdapter(requireContext(),viewModel.listOfTeacherDetail)
        recyclerView.adapter = adapter
    }
}