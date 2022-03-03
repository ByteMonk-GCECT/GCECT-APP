package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.PdfInfo
import com.gcect.gcectapp.viewmodels.PdfViewerViewModel

class HomeNoticeRecyclerAdapter(private val list:List<PdfInfo>,private val listener:OnHomeNoticeItemClickListener) :
    RecyclerView.Adapter<HomeNoticeRecyclerAdapter.HomeNoticeRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeNoticeRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_notice_item, parent, false)

        return HomeNoticeRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeNoticeRecyclerViewHolder, position: Int) {
        holder.rlNoticeHome.setOnClickListener {
            listener.onNoticeBtnClick(position,list[position].pdfTitle)
        }
        holder.txtNoticeHomeTitle.text = list[position].pdfTitle
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HomeNoticeRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rlNoticeHome: RelativeLayout = itemView.findViewById(R.id.rlNoticeHome)
        val txtNoticeHomeTitle: TextView = itemView.findViewById(R.id.txtNoticeHomeTitle)

    }
}

interface OnHomeNoticeItemClickListener{
    fun onNoticeBtnClick(pos:Int,title:String)
}