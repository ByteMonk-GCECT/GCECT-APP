package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.PdfInfo

class HomeBottomSheetRecyclerAdapter(
    private val list: List<PdfInfo>,
    private val listener: OnBottomSheetItemClickListener
) : RecyclerView.Adapter<HomeBottomSheetRecyclerAdapter.HomeBottomSheetRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeBottomSheetRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_page_bottom_sheet_list_item, parent, false)
        return HomeBottomSheetRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeBottomSheetRecyclerViewHolder, position: Int) {
        holder.llBottomSheetItem.setOnClickListener {
            listener.onBottomSheetItemClick(position,list[position].pdfTitle)
        }
        holder.txtBottomSheetNoticeTitle.text = list[position].pdfTitle
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HomeBottomSheetRecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val llBottomSheetItem: LinearLayout = itemView.findViewById(R.id.llBottomSheetItems)
        val txtBottomSheetNoticeTitle: TextView =
            itemView.findViewById(R.id.txtBottomSheetNoticeTitle)

    }
}

interface OnBottomSheetItemClickListener {
    fun onBottomSheetItemClick(pos: Int, title:String)
}