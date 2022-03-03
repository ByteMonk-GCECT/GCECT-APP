package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.DownloadViewListModel
import com.gcect.gcectapp.utils.SemScheduleViewModelCallBack

class SemScheduleViewModel22:ViewModel(), SemScheduleViewModelCallBack {
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
        addDataToOddSemList()
    }

    private fun addDataToOddSemList(){
        _oddSemList.add(DownloadViewListModel("Online Examination Schedule for B.Tech/M.Tech. Mid-Term-II for 1st semester",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd1.pdf?alt=media&token=20808b83-f9f4-4cc1-9ce7-22fbac7ff509"))

        _oddSemList.add(DownloadViewListModel("Online Examination Schedule for Semester End (Odd Semester) Examination",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd2.pdf?alt=media&token=3fd03dae-747e-4e8a-89e7-70b7f4f2fd6b"))

        _oddSemList.add(DownloadViewListModel("Online Examination Schedule (MID TERM II) for M.Tech (CT) 3rd Semester & B.Tech(CT) 7th Semester",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd3.pdf?alt=media&token=6d96f9e0-f2e3-4ae7-acad-7bf6747f5366"))

        _oddSemList.add(DownloadViewListModel("Online Examination Schedule for B. Tech/M.Tech. Mid-Term-I for 1st semester & MID TERM II for others",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd4.pdf?alt=media&token=700a802d-6bdb-4d27-8e44-b0985957dc33"))

        _oddSemList.add(DownloadViewListModel("Online Examination Schedule (SPECIAL MID TERM I) for B. Tech. 3rd Semester",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd5.pdf?alt=media&token=24291cfb-541d-491e-a1bb-ae9bc54380ba"))

        _oddSemList.add(DownloadViewListModel("Online Examination Schedule (MID TERM I) for B. Tech/M.Tech except Ist Sem",
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/pdfs%2FExam%20Schedule%20Pdfs%2F2021%20-%202022%2Fodd6.pdf?alt=media&token=73f01b07-b0f5-44c0-bba3-380302170cad"))
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