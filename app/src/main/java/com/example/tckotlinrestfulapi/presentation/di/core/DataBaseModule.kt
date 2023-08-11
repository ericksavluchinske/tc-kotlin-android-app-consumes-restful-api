package com.example.tckotlinrestfulapi.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.example.tckotlinrestfulapi.data.db.AppDatabase
import com.example.tckotlinrestfulapi.data.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideUserDataBase(app: Application): AppDatabase {
        return Room.databaseBuilder(app,AppDatabase::class.java,"appdata")
            .build()
    }
    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}