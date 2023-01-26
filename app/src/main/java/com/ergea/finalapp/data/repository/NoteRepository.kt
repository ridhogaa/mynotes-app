package com.ergea.finalapp.data.repository

import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.data.local.datasource.NoteLocalDataSource
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

interface NoteRepository {
    suspend fun getListNotes(id_user: Int): List<NoteEntity>
    suspend fun addNote(noteEntity: NoteEntity)
    suspend fun deleteNote(id_note: Int, id_user: Int)
    suspend fun updateNote(title: String, desc: String, id_note: Int, id_user: Int)
}

class NoteRepositoryImpl @Inject constructor(private val noteLocalDataSource: NoteLocalDataSource) :
    NoteRepository {
    override suspend fun getListNotes(id_user: Int): List<NoteEntity> =
        noteLocalDataSource.getListNotes(id_user).map {
            NoteEntity(
                it.idNote,
                it.idUser,
                it.title,
                it.description
            )
        }

    override suspend fun addNote(noteEntity: NoteEntity) = noteLocalDataSource.addNote(noteEntity)

    override suspend fun deleteNote(id_note: Int, id_user: Int) =
        noteLocalDataSource.deleteNote(id_note, id_user)

    override suspend fun updateNote(title: String, desc: String, id_note: Int, id_user: Int) =
        noteLocalDataSource.updateNote(title, desc, id_note, id_user)

}