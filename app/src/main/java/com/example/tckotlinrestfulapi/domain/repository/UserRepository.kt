package com.example.tckotlinrestfulapi.domain.repository

import com.example.tckotlinrestfulapi.data.model.user.User

interface UserRepository {

    suspend fun getUsers(): List<User>?

    suspend fun updateUsers(): List<User>?
}