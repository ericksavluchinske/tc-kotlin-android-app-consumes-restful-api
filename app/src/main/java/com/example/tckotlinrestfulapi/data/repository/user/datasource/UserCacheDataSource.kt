package com.example.tckotlinrestfulapi.data.repository.user.datasource

import com.example.tckotlinrestfulapi.data.model.user.User

interface UserCacheDataSource {

    suspend fun getUsersFromCache(): List<User>

    suspend fun saveUsersToCache(users: List<User>)
}