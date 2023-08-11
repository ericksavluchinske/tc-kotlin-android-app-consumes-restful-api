package com.example.tckotlinrestfulapi.presentation.di.user

import com.example.tckotlinrestfulapi.domain.usecase.GetUsersUseCase
import com.example.tckotlinrestfulapi.domain.usecase.UpdateUsersUseCase
import com.example.tckotlinrestfulapi.presentation.user.UsersViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class UserModule {
    @ActivityScoped
    @Provides
    fun provideUsersViewModelFactory(
        getUsersUseCase: GetUsersUseCase,
        updateUsersUseCase: UpdateUsersUseCase
    ): UsersViewModelFactory {
        return UsersViewModelFactory(
            getUsersUseCase,
            updateUsersUseCase
        )
    }
}