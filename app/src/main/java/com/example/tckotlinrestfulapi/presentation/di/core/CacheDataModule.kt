package com.example.tckotlinrestfulapi.presentation.di.core

import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserCacheDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl.UserCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideUserCacheDataSource(): UserCacheDataSource {
        return UserCacheDataSourceImpl()
    }
}