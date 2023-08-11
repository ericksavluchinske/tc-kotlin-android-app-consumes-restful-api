package com.example.tckotlinrestfulapi.presentation.di.core

import com.example.tckotlinrestfulapi.data.api.APIService
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserRemoteDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideUserRemoteDataSource(apiService: APIService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(
            apiService
        )
    }
}