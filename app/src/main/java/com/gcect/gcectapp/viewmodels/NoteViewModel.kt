package com.gcect.gcectapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gcect.gcectapp.model.NoteEntity
import com.gcect.gcectapp.repository.NoteRepository
import com.gcect.gcectapp.room.NoteDatabase
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<NoteEntity>>
    val repository: NoteRepository

    var editNote:NoteEntity? = null

    init {
        val dao= NoteDatabase.getDatabase(application).noteDao()
        repository=NoteRepository(dao)
        allNotes=repository.getAllNotes()
    }
    fun insertNote(note: NoteEntity) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun deleteNote(uid: Long) = viewModelScope.launch {
        repository.deleteNote(uid)
    }

    fun updateNote(uid: Long, noteTitle: String, noteBody: String) = viewModelScope.launch {
        repository.updateNote(uid, noteTitle, noteBody)
    }

    @JvmName("setEditNote1")
    fun setEditNote(noteEntity: NoteEntity){
        editNote = noteEntity
    }

}