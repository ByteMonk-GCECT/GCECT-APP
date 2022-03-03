package com.gcect.gcectapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gcect.gcectapp.model.NoteEntity

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note:NoteEntity)

    @Query("Delete from note_Table where id=:uid")
    suspend fun deleteNote(uid:Long)

    @Query("Select * from note_Table")
    fun getAllNotes(): LiveData<List<NoteEntity>>

    @Query("update note_table set title=:noteTitle, note=:noteBody where id=:uid")
    suspend fun updateNote (uid:Long,noteTitle:String,noteBody:String)
}