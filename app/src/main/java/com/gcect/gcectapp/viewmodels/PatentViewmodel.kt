package ViewModel

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.PatentDetails


class PatentViewmodel:ViewModel() {
    private val _listOfPatentDetail = ArrayList<PatentDetails>()
    val listOfPatentDetail: List<PatentDetails> = _listOfPatentDetail

    init {
        addPatentDetailToList("S. Maitra, et. al.  :Scouring powder Composition and a process there of,(between GCECT and CFRI, Dhanbad) European Patent, 10/107,613, March, 27, 2002.")
        addPatentDetailToList("SampaChakraborty, S. Maitra and R.C. Das, Ceramic glazing pigments from chrome iron sludge, (No. PAA 1918) submitted to NRDC.")
    }

    private fun addPatentDetailToList(detail: String) {
        val patentDetail = PatentDetails(detail)
        _listOfPatentDetail.add(patentDetail)
    }
}


