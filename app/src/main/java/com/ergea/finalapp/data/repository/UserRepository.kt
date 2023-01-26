package com.ergea.finalapp.data.repository

import com.ergea.finalapp.data.local.database.entity.UserEntity
import com.ergea.finalapp.data.local.datasource.UserLocalDataSource
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

interface UserRepository {
    fun getUserIfExist(email: String, password: String): UserEntity
    fun checkEmailIfExist(email: String): Boolean
    suspend fun getUserById(id_user: Int): UserEntity
    suspend fun registerUser(userEntity: UserEntity)
}

class UserRepositoryImpl @Inject constructor(private val userLocalDataSource: UserLocalDataSource) :
    UserRepository {
    override fun getUserIfExist(email: String, password: String): UserEntity =
        userLocalDataSource.getUserIfExist(email, password)

    override fun checkEmailIfExist(email: String): Boolean =
        userLocalDataSource.checkEmailIfExist(email)

    override suspend fun getUserById(id_user: Int): UserEntity =
        userLocalDataSource.getUserById(id_user)

    override suspend fun registerUser(userEntity: UserEntity) =
        userLocalDataSource.registerUser(userEntity)

}