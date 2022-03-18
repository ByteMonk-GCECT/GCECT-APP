package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.CollaborationDetails



class CollaborationRecyclerAdapter (
    private val context: Context,
    private val collaborationDetailList: List<CollaborationDetails>
):
    RecyclerView.Adapter<CollaborationRecyclerAdapter.CollaborationRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): CollaborationRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.collaboration_recyclerview_item, parent, false)

        return CollaborationRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CollaborationRecyclerViewHolder,
        position: Int
    ) {
        holder.txtcollaborationDetail.text=collaborationDetailList[position].collaborationtext


    }

    override fun getItemCount(): Int {
        return collaborationDetailList.size
    }

    inner class CollaborationRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val txtcollaborationDetail: TextView = itemView.findViewById(R.id.tv_collaboration_item)
    }



}
