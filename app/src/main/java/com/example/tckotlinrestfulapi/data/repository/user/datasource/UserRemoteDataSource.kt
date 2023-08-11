package com.example.tckotlinrestfulapi.data.repository.user.datasource

import com.example.tckotlinrestfulapi.data.model.user.UserList
import retrofit2.Response

interface UserRemoteDataSource {

    suspend fun getUsers(): Response<UserList>
}