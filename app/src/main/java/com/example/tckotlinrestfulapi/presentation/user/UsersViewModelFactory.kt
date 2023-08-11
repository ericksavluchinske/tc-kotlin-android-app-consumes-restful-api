package com.example.tckotlinrestfulapi.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tckotlinrestfulapi.domain.usecase.GetUsersUseCase
import com.example.tckotlinrestfulapi.domain.usecase.UpdateUsersUseCase

class UsersViewModelFactory(
    private val getUsersUseCase: GetUsersUseCase,
    private val updateUsersUseCase: UpdateUsersUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(getUsersUseCase,updateUsersUseCase) as T
    }
}