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
@Entity(tableName = "users")
class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id_user")
    var idUser: Int? = null,
    @field:ColumnInfo(name = "email")
    var email: String? = null,
    @field:ColumnInfo(name = "password")
    var password: String? = null,
) : Parcelable