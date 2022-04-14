package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.NoteEntity
import java.util.ArrayList

class NoteRecyclerAdapter(private val listener: NoteItemClickListener):RecyclerView.Adapter<NoteRecyclerAdapter.NoteRecyclerViewHolder>() {
    private val list = ArrayList<NoteEntity>()
    inner class NoteRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNoteTitle:TextView = itemView.findViewById(R.id.txtNoteTitle)
        val txtNoteBody:TextView = itemView.findViewById(R.id.txtNoteBody)
        val imgEdit:ImageView = itemView.findViewById(R.id.imgEditNote)
        val imgDelete:ImageView = itemView.findViewById(R.id.imgDeleteNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_recycler_item, parent, false)
        return NoteRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteRecyclerViewHolder, position: Int) {
        holder.txtNoteTitle.text = list[position].title
        holder.txtNoteBody.text = list[position].note
        holder.imgEdit.setOnClickListener {
            listener.onEditBtnPressed(list[position])
        }
        holder.imgDelete.setOnClickListener {
            listener.onDeleteBtnPressed(list[position].id)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: List<NoteEntity>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}

interface NoteItemClickListener{
    fun onDeleteBtnPressed(uid:Long)
    fun onEditBtnPressed(note:NoteEntity)
}