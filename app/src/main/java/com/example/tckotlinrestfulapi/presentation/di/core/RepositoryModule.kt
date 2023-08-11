package com.example.tckotlinrestfulapi.presentation.di.core

import com.example.tckotlinrestfulapi.data.repository.user.UserRepositoryImpl
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserCacheDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserLocalDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserRemoteDataSource
import com.example.tckotlinrestfulapi.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource,
        userLocalDataSource: UserLocalDataSource,
        userCacheDataSource: UserCacheDataSource
    ): UserRepository {

        return UserRepositoryImpl(
            userRemoteDataSource,
            userLocalDataSource,
            userCacheDataSource
        )
    }
}