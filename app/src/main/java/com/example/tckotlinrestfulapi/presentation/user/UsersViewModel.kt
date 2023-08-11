package com.example.tckotlinrestfulapi.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tckotlinrestfulapi.domain.usecase.GetUsersUseCase
import com.example.tckotlinrestfulapi.domain.usecase.UpdateUsersUseCase

class UsersViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val updateUsersUseCase: UpdateUsersUseCase
): ViewModel() {

    fun getUsers() = liveData {
        val userList = getUsersUseCase.execute()
        emit(userList)
    }

    fun updateUsers() = liveData {
        val userList = updateUsersUseCase.execute()
        emit(userList)
    }
}