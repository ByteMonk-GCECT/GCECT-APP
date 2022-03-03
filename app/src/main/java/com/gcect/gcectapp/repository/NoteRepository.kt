package com.gcect.gcectapp.repository

import androidx.lifecycle.LiveData
import com.gcect.gcectapp.model.NoteEntity
import com.gcect.gcectapp.room.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insertNote(note: NoteEntity){
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(uid:Long){
        noteDao.deleteNote(uid)
    }

    fun getAllNotes(): LiveData<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun updateNote (uid:Long,noteTitle:String,noteBody:String){
        noteDao.updateNote(uid,noteTitle,noteBody)
    }
}