package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.StaticAboutUsFragmentBinding

class TheInstituteViewFragment: Fragment() {
    private lateinit var binding: StaticAboutUsFragmentBinding
    private val instituteImgUrl = "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/About%20Us%2FThe%20Institute%2Fimg%2001.jpg?alt=media&token=9482f052-a36a-4828-ac34-7a0a77e7ff3f"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.static_about_us_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pageTitle = "About Us"
        binding.pageDesc = getString(R.string.history_page)
        val instituteImg = binding.gcectAboutUsImage
        Glide.with(requireContext()).load(instituteImgUrl).into(instituteImg)
    }
}