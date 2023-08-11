package com.example.tckotlinrestfulapi.data.repository.user.datasource

import com.example.tckotlinrestfulapi.data.model.user.User

interface UserLocalDataSource {

    suspend fun getUsersFromDB(): List<User>

    suspend fun saveUsersToDB(users: List<User>)

    suspend fun clearAll()
}