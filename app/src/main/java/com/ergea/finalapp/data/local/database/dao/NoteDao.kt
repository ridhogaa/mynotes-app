package com.ergea.finalapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ergea.finalapp.data.local.database.entity.NoteEntity

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Dao
interface NoteDao {

    @Query("SELECT * from notes where id_user =:id_user ORDER BY id_note DESC")
    suspend fun getListNotes(id_user: Int): List<NoteEntity>

    @Insert
    suspend fun addNote(noteEntity: NoteEntity)

    @Query("DELETE FROM notes WHERE id_note=:id_note AND id_user=:id_user")
    suspend fun deleteNote(id_note: Int, id_user: Int)

    @Query("UPDATE notes SET title =:title, description =:desc WHERE id_note=:id_note AND id_user=:id_user")
    suspend fun updateNote(title: String, desc: String, id_note: Int, id_user: Int)
}