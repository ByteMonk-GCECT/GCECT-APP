package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.ProjectDetail
import com.gcect.gcectapp.model.TeacherDetail

class ResearchDevelopmentViewModel : ViewModel() {
   private val _listOfTeacherDetail = ArrayList<TeacherDetail>()
    val listOfTeacherDetail:List<TeacherDetail> = _listOfTeacherDetail

    init {
        addTeacherDetailToList(
            "Dr. Mausumi Maitra",
        "Associate Prof. HOD(IT)",
        addProjectDetailsToList(
            ProjectDetail("Development of VLSI Laboratory","AICTE (MODROBS)","6.6 Lakh","Completed"),
            ProjectDetail("Development of Image Processing & GIS Laboratory","AICTE (MODROBS)","10 Lakh","On-Going"),
            ProjectDetail("Development of Image Processing & Computer Vision Laboratory","AICTE (MODROBS)","9 Lakh","On-Going"),
            ProjectDetail("Development of IP Core for implementation of Image Processing Algorithms on FPGA Board","UGC-Major Research Project","6.97 Lakh","Completed")
        ))
    }
   private fun addProjectDetailsToList(vararg projectDetail: ProjectDetail) = projectDetail.toList()

   private fun addTeacherDetailToList(
        name: String,
        designation: String,
        projectDetailList: List<ProjectDetail>
    ) {
        val teacherDetail = TeacherDetail(name, designation, projectDetailList)
        _listOfTeacherDetail.add(teacherDetail)
    }
}