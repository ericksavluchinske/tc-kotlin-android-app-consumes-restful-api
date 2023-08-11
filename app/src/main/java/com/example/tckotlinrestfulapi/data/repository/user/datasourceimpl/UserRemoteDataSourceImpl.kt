package com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl

import com.example.tckotlinrestfulapi.data.api.APIService
import com.example.tckotlinrestfulapi.data.model.user.UserList
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserRemoteDataSource
import retrofit2.Response

class UserRemoteDataSourceImpl(
    private val apiService: APIService,
): UserRemoteDataSource {
    override suspend fun getUsers(): Response<UserList> = apiService.getUsers()

}