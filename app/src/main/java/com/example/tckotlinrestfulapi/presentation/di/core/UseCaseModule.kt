package com.example.tckotlinrestfulapi.presentation.di.core

import com.example.tckotlinrestfulapi.domain.repository.UserRepository
import com.example.tckotlinrestfulapi.domain.usecase.GetUsersUseCase
import com.example.tckotlinrestfulapi.domain.usecase.UpdateUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }
    @Provides
    fun provideUpdateUsersUseCase(userRepository: UserRepository): UpdateUsersUseCase {
        return UpdateUsersUseCase(userRepository)
    }
}