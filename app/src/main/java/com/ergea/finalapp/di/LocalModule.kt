package com.ergea.finalapp.di

import android.content.Context
import com.ergea.finalapp.data.local.database.AppDatabase
import com.ergea.finalapp.data.local.database.dao.NoteDao
import com.ergea.finalapp.data.local.database.dao.UserDao
import com.ergea.finalapp.data.local.datastore.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getAppDB(context)

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase): UserDao =
        database.userDao()

    @Singleton
    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao =
        database.noteDao()
}