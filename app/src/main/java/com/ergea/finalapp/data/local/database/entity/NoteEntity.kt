package com.ergea.finalapp.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Parcelize
@Entity(tableName = "notes")
class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id_note")
    var idNote: Int? = null,
    @field:ColumnInfo(name = "id_user")
    var idUser: Int? = null,
    @field:ColumnInfo(name = "title")
    var title: String? = null,
    @field:ColumnInfo(name = "description")
    var description: String? = null,
) : Parcelable