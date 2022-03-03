package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.DownloadViewListModel
import com.gcect.gcectapp.utils.SemScheduleViewModelCallBack

class SemScheduleViewModel20:ViewModel(), SemScheduleViewModelCallBack {
    private val _evenSemList = ArrayList<DownloadViewListModel>()
    val evenSemList
        get() = _evenSemList

    private val _oddSemList = ArrayList<DownloadViewListModel>()
    val oddSemList
        get() = _oddSemList

    private var _listPos = -1
    val listPos
        get() = _listPos

    private var _isEvenList = true
    val isEvenList
        get() = _isEvenList

    private var _navFragId = -1
    val navFragId
        get() = _navFragId

    init {
        addDataToEvenSemList()
    }
    private fun addDataToEvenSemList(){
        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End (Even Semester) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2019-20%2Feven1.pdf?alt=media&token=c8fff8e4-68a2-4fb6-a847-35579045ec5e")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Final Semester (B.Tech 8th Sem) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2019-20%2Feven2.pdf?alt=media&token=55d79f9f-cc46-409c-88b1-06db11399b3e")
        )
    }


    override fun setListPosAndType(pos:Int,isEven:Boolean){
        _listPos = pos
        _isEvenList = isEven
    }


    override fun setNavFragId(id:Int){
        _navFragId = id
    }
    fun getList(isEven:Boolean):List<DownloadViewListModel>{
        return if(isEven) evenSemList else oddSemList
    }
}