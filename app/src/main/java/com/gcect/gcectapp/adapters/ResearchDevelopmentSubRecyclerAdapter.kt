package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.ProjectDetail

class ResearchDevelopmentSubRecyclerAdapter(private val context: Context, private val projectDetailList:List<ProjectDetail>) :
    RecyclerView.Adapter<ResearchDevelopmentSubRecyclerAdapter
    .ResearchDevelopmentSubRecyclerViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResearchDevelopmentSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.research_dev_recycler_sub_item, parent, false)

        return ResearchDevelopmentSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ResearchDevelopmentSubRecyclerViewHolder,
        position: Int
    ) {
        holder.txtProjectTitle.text = context.getString(R.string.r_d_project_title,projectDetailList[position].title)
        holder.txtProjectFundingAgency.text = context.getString(R.string.r_d_project_funding_agency,projectDetailList[position].fundingAgency)
        holder.txtProjectAmount.text = context.getString(R.string.r_d_project_amount,projectDetailList[position].amount)
        holder.txtProjectStatus.text = context.getString(R.string.r_d_project_status,projectDetailList[position].status)
         if(position == 0){
             holder.upperWhiteLine.visibility = View.GONE
         }
    }

    override fun getItemCount(): Int {
        return projectDetailList.size
    }

    inner class ResearchDevelopmentSubRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            val txtProjectTitle:TextView = itemView.findViewById(R.id.txtProjectTitle)
            val txtProjectFundingAgency:TextView = itemView.findViewById(R.id.txtProjectFundingAgency)
            val txtProjectAmount:TextView = itemView.findViewById(R.id.txtProjectAmount)
            val txtProjectStatus:TextView = itemView.findViewById(R.id.txtProjectStatus)
            val upperWhiteLine:View = itemView.findViewById(R.id.upperWhiteLine)

    }
}