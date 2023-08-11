package com.example.tckotlinrestfulapi.presentation.di.core

import com.example.tckotlinrestfulapi.data.db.UserDao
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserLocalDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDao)
    }
}