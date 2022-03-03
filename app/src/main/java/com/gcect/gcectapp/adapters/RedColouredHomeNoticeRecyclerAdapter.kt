package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.PdfInfo

class RedColouredHomeNoticeRecyclerAdapter(private val list:List<PdfInfo>, private val listener:OnHomeRedNoticeItemClickListener)
    :RecyclerView.Adapter<RedColouredHomeNoticeRecyclerAdapter.RedColouredHomeNoticeViewHolder>() {

    inner class RedColouredHomeNoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txtNoticeTitle: TextView = itemView.findViewById(R.id.txtNoticeTitle)
        val rlRedColouredNotice: RelativeLayout = itemView.findViewById(R.id.rlRedColoredNotice)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RedColouredHomeNoticeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.red_coloured_notice_recycler_item, parent, false)

        return RedColouredHomeNoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedColouredHomeNoticeViewHolder, position: Int) {
        holder.rlRedColouredNotice.setOnClickListener {
            listener.onRedNoticeBtnClick(position,list[position].pdfTitle)
        }
        holder.txtNoticeTitle.text = list[position].pdfTitle
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface OnHomeRedNoticeItemClickListener{
    fun onRedNoticeBtnClick(pos:Int,title:String)
}