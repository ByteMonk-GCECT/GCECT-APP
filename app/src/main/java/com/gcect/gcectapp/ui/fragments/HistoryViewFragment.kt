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

class HistoryViewFragment: Fragment() {
    private lateinit var binding: StaticAboutUsFragmentBinding
    private val historyImgUrl = "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/About%20Us%2FHistory%2Fgcect_history_img.jpg?alt=media&token=e5e67b13-5254-4fa4-aebd-9e7b6d0c1f57"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.static_about_us_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pageDesc = getString(R.string.history_page)
        binding.pageTitle = "HISTORY"
        val historyImg = binding.gcectAboutUsImage
        Glide.with(requireContext()).load(historyImgUrl).into(historyImg)
    }
}