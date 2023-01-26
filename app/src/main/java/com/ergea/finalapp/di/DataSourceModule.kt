package com.ergea.finalapp.di

import com.ergea.finalapp.data.local.datasource.NoteLocalDataSource
import com.ergea.finalapp.data.local.datasource.NoteLocalDataSourceImpl
import com.ergea.finalapp.data.local.datasource.UserLocalDataSource
import com.ergea.finalapp.data.local.datasource.UserLocalDataSourceImpl
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
abstract class DataSourceModule {

    @Binds
    abstract fun provideNoteLocalDataSource(noteLocalDataSourceImpl: NoteLocalDataSourceImpl): NoteLocalDataSource

    @Binds
    abstract fun provideUserLocalDataSource(userLocalDataSourceImpl: UserLocalDataSourceImpl): UserLocalDataSource

}