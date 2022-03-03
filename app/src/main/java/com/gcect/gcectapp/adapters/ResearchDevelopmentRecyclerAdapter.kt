package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.TeacherDetail

class ResearchDevelopmentRecyclerAdapter(
    private val context: Context,
    private val teacherDetailList: List<TeacherDetail>
) :
    RecyclerView.Adapter<ResearchDevelopmentRecyclerAdapter
    .ResearchDevelopmentRecyclerViewHolder>() {
    private var isClicked: Boolean = true
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResearchDevelopmentRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.research_dev_recycler_item, parent, false)

        return ResearchDevelopmentRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ResearchDevelopmentRecyclerViewHolder,
        position: Int
    ) {
        holder.txtTeacherDetail.text = context.getString(
            R.string.r_d_teacher_detail,
            teacherDetailList[position].teacherName,
            teacherDetailList[position].teacherDesignation
        )
        recyclerViewSetup(holder.subRVProjectDetail, position)
        holder.btnViewStatus.setOnClickListener {
            if (isClicked) {
                holder.subRVProjectDetail.visibility = View.VISIBLE
                holder.btnViewStatus.text = "VIEW LESS"
                isClicked = false
            } else {
                holder.subRVProjectDetail.visibility = View.GONE
                holder.btnViewStatus.text = "VIEW MORE"
                isClicked = true
            }
        }

    }

    override fun getItemCount(): Int {
        return teacherDetailList.size
    }

    inner class ResearchDevelopmentRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtTeacherDetail: TextView = itemView.findViewById(R.id.txtTeacherDetail)
        val subRVProjectDetail: RecyclerView = itemView.findViewById(R.id.subRVProjectDetail)
        val btnViewStatus: MaterialButton = itemView.findViewById(R.id.btnViewStatus)

    }

    private fun recyclerViewSetup(recyclerView: RecyclerView, position: Int) {
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter =
            ResearchDevelopmentSubRecyclerAdapter(context, teacherDetailList[position].projectList)
        recyclerView.adapter = adapter
    }
}