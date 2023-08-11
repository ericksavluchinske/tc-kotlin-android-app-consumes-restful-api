package com.example.tckotlinrestfulapi.domain.usecase

import com.example.tckotlinrestfulapi.data.model.user.User
import com.example.tckotlinrestfulapi.domain.repository.UserRepository

class UpdateUsersUseCase(private val userRepository: UserRepository) {
    suspend fun execute(): List<User>? = userRepository.updateUsers()
}