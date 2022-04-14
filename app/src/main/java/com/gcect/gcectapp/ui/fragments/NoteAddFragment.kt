package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.FragmentNoteAddBinding
import com.gcect.gcectapp.model.NoteEntity
import com.gcect.gcectapp.viewmodels.NoteViewModel

class NoteAddFragment : Fragment() {
    private lateinit var binding: FragmentNoteAddBinding
    val noteViewModel by lazy {
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_add, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel.editNote?.let {
            binding.txtNoteEnteredTitle.setText(it.title)
            binding.txtNoteEnteredBody.setText(it.note)
            binding.btnSaveTask.text = "UPDATE NOTE"
        }
        binding.btnSaveTask.setOnClickListener {
            if (binding.txtNoteEnteredTitle.text.isNullOrEmpty())
                binding.txtNoteEnteredTitle.error = getString(R.string.title_empty_error_message)
            else if (binding.txtNoteEnteredBody.text.isNullOrEmpty())
                binding.txtNoteEnteredTitle.error = getString(R.string.title_empty_error_message)
            else {
                val title = binding.txtNoteEnteredTitle.text
                val noteBody = binding.txtNoteEnteredBody.text
                if(noteViewModel.editNote==null){
                    val note = NoteEntity(title.toString(), noteBody.toString())
                    noteViewModel.insertNote(note)
                }else{
                    noteViewModel.updateNote(noteViewModel.editNote!!.id,title.toString(),noteBody.toString())
                }
                navigate(
                    R.id.noteShowFragment
                )
            }
        }

        onBackPressed()
    }

    private fun onBackPressed() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here
                    navigate(
                        R.id.noteShowFragment
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