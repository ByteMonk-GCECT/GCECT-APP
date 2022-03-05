package ViewModel

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.CollaborationDetails



class CollaborationViewmodel:ViewModel() {
    private val _listOfCollaborationDetail = ArrayList<CollaborationDetails>()
    val listOfCollaborationDetail:List<CollaborationDetails> = _listOfCollaborationDetail

    init{
        addCollaborationDetailToList("Some impacts evident at the College as a result of its collaborations with other agencies are as follows:")
        addCollaborationDetailToList("Establishment for centre for Jute Cement Composite research in collaboration with IIT, Kharagpur.")
        addCollaborationDetailToList("Student of both the institute share laboratory facilities with Chemical Engineering and Chemical TechnologyDeptt. Of Calcutta University and Metallurgy Dept. of Jadavpur University.")
        addCollaborationDetailToList("Involvement of all PG students of Ceramic Technology (2010-12)with financial support in research funded by private entrepreneurs, Progressive Enterprise Pvt. Ltd.")
        addCollaborationDetailToList("Involvement of few passed out UG  students in projects funded by private agencies like Aditya Birla Insulators Ltd., Sepulchre Brothers (India) Pvt. Ltd. Etc.")
        addCollaborationDetailToList("Regular visit of industry personal of collaborative industry for interaction with the student and the faculty members.")
    }

    private fun addCollaborationDetailToList(detail: String) {
        val collaborationDetail = CollaborationDetails(detail)
        _listOfCollaborationDetail.add(collaborationDetail)
    }

}
