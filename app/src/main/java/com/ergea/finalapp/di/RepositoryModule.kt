package com.ergea.finalapp.di

import com.ergea.finalapp.data.local.datasource.NoteLocalDataSource
import com.ergea.finalapp.data.local.datasource.NoteLocalDataSourceImpl
import com.ergea.finalapp.data.local.datasource.UserLocalDataSource
import com.ergea.finalapp.data.local.datasource.UserLocalDataSourceImpl
import com.ergea.finalapp.data.repository.NoteRepository
import com.ergea.finalapp.data.repository.NoteRepositoryImpl
import com.ergea.finalapp.data.repository.UserRepository
import com.ergea.finalapp.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

    @Binds
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository


}