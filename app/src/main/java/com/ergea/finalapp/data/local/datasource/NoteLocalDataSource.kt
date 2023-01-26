package com.ergea.finalapp.data.local.datasource

import com.ergea.finalapp.data.local.database.dao.NoteDao
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

interface NoteLocalDataSource {
    suspend fun getListNotes(id_user: Int): List<NoteEntity>
    suspend fun addNote(noteEntity: NoteEntity)
    suspend fun deleteNote(id_note: Int, id_user: Int)
    suspend fun updateNote(title: String, desc: String, id_note: Int, id_user: Int)
}

class NoteLocalDataSourceImpl @Inject constructor(private val noteDao: NoteDao) :
    NoteLocalDataSource {
    override suspend fun getListNotes(id_user: Int): List<NoteEntity> =
        noteDao.getListNotes(id_user)

    override suspend fun addNote(noteEntity: NoteEntity) = noteDao.addNote(noteEntity)

    override suspend fun deleteNote(id_note: Int, id_user: Int) =
        noteDao.deleteNote(id_note, id_user)

    override suspend fun updateNote(title: String, desc: String, id_note: Int, id_user: Int) =
        noteDao.updateNote(title, desc, id_note, id_user)
}

