package com.gcect.gcectapp.model

data class TeacherDetail(
    val teacherName:String,
    val teacherDesignation:String,
    val projectList:List<ProjectDetail>
)

data class ProjectDetail(
    val title: String,
    val fundingAgency: String,
    val amount: String,
    val status: String
)