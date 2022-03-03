package com.gcect.gcectapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.ExaminationScheduleViewPagerAdapter
import com.gcect.gcectapp.databinding.ExaminationSchedulePageBinding
import com.google.android.material.tabs.TabLayoutMediator

class ExamScheduleFragment : Fragment() {
    private lateinit var binding :ExaminationSchedulePageBinding
    private val semesterTypeArray = arrayOf(
        "Even Semester",
        "Odd Semester"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.examination_schedule_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        binding.txtPageTitle.text = "Exam Schedules"
        val adapter = ExaminationScheduleViewPagerAdapter(parentFragmentManager, lifecycle,findNavController())
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = semesterTypeArray[position]
        }.attach()
    }
}