package com.gcect.gcectapp.model

data class NavBaseItem(
    val title: String,
    val icon:Int,
    val navSubItemList:List<NavSubItem?>
)
