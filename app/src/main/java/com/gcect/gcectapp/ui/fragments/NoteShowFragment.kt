package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.NoteItemClickListener
import com.gcect.gcectapp.adapters.NoteRecyclerAdapter
import com.gcect.gcectapp.model.NoteEntity
import com.gcect.gcectapp.viewmodels.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteShowFragment : Fragment(), NoteItemClickListener {
    lateinit var rvNoteList: RecyclerView
    lateinit var btnAddNote: FloatingActionButton
    lateinit var imgNoData: ImageView
    private val noteViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        ).get(NoteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NoteRecyclerAdapter(this)
        rvNoteList = view.findViewById<RecyclerView>(R.id.rvNoteList)
        btnAddNote = view.findViewById<FloatingActionButton>(R.id.btnAddNote)
        imgNoData = view.findViewById(R.id.imgNoDataFound)
        // initialize staggered grid layout manager
        StaggeredGridLayoutManager(
            2, // span count
            StaggeredGridLayoutManager.VERTICAL // orientation
        ).apply {
            // specify the layout manager for recycler view
            rvNoteList.layoutManager = this
        }
        rvNoteList.adapter = adapter

        noteViewModel.allNotes.observe(viewLifecycleOwner, Observer { list ->
            adapter.updateList(list)
            if (list.isEmpty()) {
                imgNoData.visibility = View.VISIBLE
            } else {
                imgNoData.visibility = View.GONE
            }
        })

        btnAddNote.setOnClickListener {
            navigate(R.id.noteAddFragment)
        }

        onBackPressed()
    }

    override fun onDeleteBtnPressed(uid: Long) {
        noteViewModel.deleteNote(uid)
    }

    override fun onEditBtnPressed(note:NoteEntity) {
        noteViewModel.setEditNote(note)
        navigate(R.id.noteAddFragment)
    }

    private fun onBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here
                    navigate(
                        R.id.homeFragment
                    )
                }
            }
            )
    }

    /**
     * For handling navigation
     */
    private fun navigate(navFragId: Int) {
        val id = findNavController().currentDestination?.id
        id?.let { findNavController().popBackStack(it, true) }
        findNavController().navigate(navFragId)
    }
}