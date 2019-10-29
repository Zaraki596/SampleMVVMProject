package com.example.android.samplemvvmproject.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.samplemvvmproject.data.db.dao.UsersDao
import com.example.android.samplemvvmproject.data.db.entity.Users

@Database(entities = [Users::class], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null
        const val DATABASE_NAME = "user_database.db"

        fun getDatabse(context: Context): UserRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(
                        context.applicationContext, UserRoomDatabase::class.java, DATABASE_NAME
                    ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}