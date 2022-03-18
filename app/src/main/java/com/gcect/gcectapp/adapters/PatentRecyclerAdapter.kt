package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R

import com.gcect.gcectapp.model.PatentDetails


class PatentRecyclerAdapter (
    private val context: Context,
    private val patentDetailList: List<PatentDetails>
): RecyclerView.Adapter<PatentRecyclerAdapter.PatentRecyclerViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): PatentRecyclerViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.patents_recyclerview_item, parent, false)

        return PatentRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PatentRecyclerViewHolder,
        position: Int) {
        holder.txtPatentDetail.text=patentDetailList[position].patenttext

    }

    override fun getItemCount(): Int {
        return patentDetailList.size
    }


    inner class PatentRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtPatentDetail: TextView = itemView.findViewById(R.id.tv_patent_item)
    }



}
