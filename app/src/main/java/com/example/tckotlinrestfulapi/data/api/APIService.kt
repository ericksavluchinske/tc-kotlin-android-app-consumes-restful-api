package com.example.tckotlinrestfulapi.data.api

import com.example.tckotlinrestfulapi.data.model.user.UserList
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("/v3/ce47ee53-6531-4821-a6f6-71a188eaaee0")
    suspend fun getUsers(): Response<UserList>
}