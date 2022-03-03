package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.DownloadViewListModel
import com.gcect.gcectapp.utils.SemScheduleViewModelCallBack

class SemScheduleViewModel21:ViewModel(), SemScheduleViewModelCallBack {
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
        addDataToOddSemList()
    }
    private fun addDataToEvenSemList(){
        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End (Even Semester) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Feven%2Feven1.pdf?alt=media&token=d42fd4a5-8032-4516-8dd8-5099a5614496")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule for Final Semester (B.Tech 8th Sem) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Feven%2Feven2.pdf?alt=media&token=b16668e7-67bc-4848-9614-a06b13743e58")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule (Mid Term - II) for B.Tech/M.Tech",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Feven%2Feven3.pdf?alt=media&token=5e2afadf-8e75-4133-adc4-ea99c3c346c2")
        )

        _evenSemList.add(
            DownloadViewListModel("Online Examination Schedule (Mid Term - I) for B.Tech/M.Tech",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Feven%2Feven4.pdf?alt=media&token=787d3060-2dfd-4a74-9728-703390a78886")
        )

    }

    private fun addDataToOddSemList(){
        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule for Semester End (Odd Semester) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Fodd%2Fodd1.pdf?alt=media&token=101fd258-4549-4c2c-8e88-150c41c19fcf")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule (Mid Term – II) for B.Tech/M.Tech",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Fodd%2Fodd2.pdf?alt=media&token=5dfafb13-a63b-4c80-97df-cc9a2fc780f1")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule (Special Mid Term – I) for B.Tech/M.Tech",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Fodd%2Fodd3.pdf?alt=media&token=2c6103e8-d4db-4f5b-8b44-93a3b790c838")
        )

        _oddSemList.add(
            DownloadViewListModel("Online Examination Schedule (Mid Term – I) for B.Tech/M.Tech",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2020-2021%2Fodd%2Fodd4.pdf?alt=media&token=9f26c60c-3069-4fd6-a427-077c147d8eb5")
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