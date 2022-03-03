package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.GateRankerDetails
import com.mikhaellopez.circularimageview.CircularImageView

class HomeGateRankerRecyclerAdapter(private val context: Context, private val list:List<GateRankerDetails>)
    :RecyclerView.Adapter<HomeGateRankerRecyclerAdapter.HomeGateRankerRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeGateRankerRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_gate_ranker_item, parent, false)
        return HomeGateRankerRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeGateRankerRecyclerViewHolder, position: Int) {
          val rankerDetail = context.getString(R.string.gate_rank,list[position].name,list[position].gateRank)
        holder.txtGateRanker.text = rankerDetail
        Glide.with(context).load(list[position].imgUrl).into(holder.imgGateRanker)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HomeGateRankerRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val imgGateRanker:CircularImageView = itemView.findViewById(R.id.imgGateRanker)
         val txtGateRanker: TextView = itemView.findViewById(R.id.txtGateRanker)
    }
}