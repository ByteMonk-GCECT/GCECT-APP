package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gcect.gcectapp.R
import com.smarteist.autoimageslider.SliderViewAdapter

class NssAutoSliderAdapter(private val context: Context, private val imgUrlList: List<String>) : SliderViewAdapter<NssAutoSliderAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.nss_slider_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(viewHolder: Holder, position: Int) {
         Glide.with(context).load(imgUrlList[position]).into(viewHolder.imageView)
    }

    override fun getCount(): Int {
        return imgUrlList.size
    }

    inner class Holder(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.nss_slider_image_view)

    }
}