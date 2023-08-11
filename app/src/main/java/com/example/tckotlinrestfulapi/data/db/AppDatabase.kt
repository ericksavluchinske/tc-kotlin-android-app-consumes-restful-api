package com.example.tckotlinrestfulapi.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tckotlinrestfulapi.data.model.user.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
}