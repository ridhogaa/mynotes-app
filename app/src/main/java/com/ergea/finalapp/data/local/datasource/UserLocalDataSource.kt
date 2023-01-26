package com.ergea.finalapp.data.local.datasource

import com.ergea.finalapp.data.local.database.dao.UserDao
import com.ergea.finalapp.data.local.database.entity.UserEntity
import javax.inject.Inject

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

interface UserLocalDataSource {
    fun getUserIfExist(email: String, password: String): UserEntity
    suspend fun getUserById(id_user: Int): UserEntity
    fun checkEmailIfExist(email: String): Boolean
    suspend fun registerUser(userEntity: UserEntity)
}

class UserLocalDataSourceImpl @Inject constructor(private val userDao: UserDao) :
    UserLocalDataSource {
    override fun getUserIfExist(email: String, password: String): UserEntity =
        userDao.getUserIfExist(email, password)

    override suspend fun getUserById(id_user: Int): UserEntity = userDao.getUserById(id_user)

    override fun checkEmailIfExist(email: String): Boolean =
        userDao.checkEmailIfExist(email)

    override suspend fun registerUser(userEntity: UserEntity) = userDao.registerUser(userEntity)
}