package com.gcect.gcectapp.utils

import com.gcect.gcectapp.model.DownloadViewListModel

interface SemScheduleViewModelCallBack {
     fun setListPosAndType(pos:Int,isEven:Boolean)
     fun setNavFragId(id:Int)
}