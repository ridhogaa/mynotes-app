package com.ergea.finalapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ergea.finalapp.data.local.database.dao.NoteDao
import com.ergea.finalapp.data.local.database.dao.UserDao
import com.ergea.finalapp.data.local.database.entity.NoteEntity
import com.ergea.finalapp.data.local.database.entity.UserEntity

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

@Database(entities = [UserEntity::class, NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun noteDao(): NoteDao

    companion object {
        private var dbINSTANCE: AppDatabase? = null
        fun getAppDB(context: Context): AppDatabase {
            if (dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "MyDB.db"
                ).allowMainThreadQueries().build()
            }
            return dbINSTANCE!!
        }
    }
}