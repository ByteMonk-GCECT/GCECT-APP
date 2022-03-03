package com.gcect.gcectapp.model

import com.gcect.gcectapp.R

data class NavSubItem(
    val title: String,
    val navSubSubItemList:List<NavSubSubItem?>,
    val icon:Int = R.drawable.close_hand_icon
)
