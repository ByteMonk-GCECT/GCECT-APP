package com.gcect.gcectapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gcect.gcectapp.ui.fragments.CSIFragment
import com.gcect.gcectapp.ui.fragments.ContactUsFragment
import com.gcect.gcectapp.ui.fragments.EvenSemScheduleFragment
import com.gcect.gcectapp.ui.fragments.OddSemScheduleFragment

private const val NUM_TABS = 2
class ExaminationScheduleViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,private val navController: NavController) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 -> EvenSemScheduleFragment(navController)
           else -> OddSemScheduleFragment(navController)
       }
    }
}