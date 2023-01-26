package com.ergea.finalapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ergea.finalapp.data.local.database.entity.UserEntity

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Dao
interface UserDao {

    @Query("SELECT * from users where email =:email AND password =:password")
    fun getUserIfExist(email: String, password: String): UserEntity

    @Query("SELECT * from users where id_user =:id_user")
    suspend fun getUserById(id_user: Int): UserEntity

    @Query("SELECT EXISTS(SELECT * FROM users WHERE email =:email)")
    fun checkEmailIfExist(email: String): Boolean

    @Insert
    suspend fun registerUser(userEntity: UserEntity)

}