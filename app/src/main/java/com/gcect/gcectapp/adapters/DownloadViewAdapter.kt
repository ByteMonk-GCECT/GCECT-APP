package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.DownloadViewListModel
import com.gcect.gcectapp.utils.SemScheduleViewModelCallBack
import com.gcect.gcectapp.viewmodels.MainActivityViewModel
import com.gcect.gcectapp.viewmodels.SemScheduleViewModel20
import com.gcect.gcectapp.viewmodels.SemScheduleViewModel21
import com.gcect.gcectapp.viewmodels.SemScheduleViewModel22
import com.google.android.material.card.MaterialCardView

class DownloadViewAdapter(
    private val navFragId:Int,
    private val list: List<DownloadViewListModel>,
    private val navController: NavController,
    private val isEven: Boolean,
    private val viewModel22: SemScheduleViewModel22,
    private val viewModel21: SemScheduleViewModel21,
    private val viewModel20: SemScheduleViewModel20,
    private val mainViewModel: MainActivityViewModel,
    private val listener:OnDownloadBtnClickListener
) : RecyclerView.Adapter<DownloadViewAdapter.DownloadViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exam_schedule_recycler_item, parent, false)
        return DownloadViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: DownloadViewViewHolder, position: Int) {
        val viewModel:SemScheduleViewModelCallBack? = when(mainViewModel.examScheduleYear){
            22 -> viewModel22
            21 -> viewModel21
            20 -> viewModel20
            else -> null
        }
        holder.txtTopic.text = list[position].title
        holder.llView.setOnClickListener {
                navController.navigate(R.id.action_examScheduleFragment_to_schedulePdfViewerFragment)
                viewModel!!.setListPosAndType(position,isEven)
                viewModel.setNavFragId(navFragId)
        }
        holder.llDownload.setOnClickListener {
            listener.onDownloadBtnPressed(list[position].pdfUrl)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DownloadViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTopic: TextView = itemView.findViewById(R.id.txtTopic)
        val mcvDownload: MaterialCardView = itemView.findViewById(R.id.mcvDownload)
        val llDownload: LinearLayout = itemView.findViewById(R.id.llDownload)
        val mcvView: MaterialCardView = itemView.findViewById(R.id.mcvView)
        val llView: LinearLayout = itemView.findViewById(R.id.llView)
    }

}

interface OnDownloadBtnClickListener{
    fun onDownloadBtnPressed(url:String)
}