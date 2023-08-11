package com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl

import com.example.tckotlinrestfulapi.data.model.user.User
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserCacheDataSource

class UserCacheDataSourceImpl: UserCacheDataSource {

    private var userList = ArrayList<User>()

    override suspend fun getUsersFromCache(): List<User> {
        return userList
    }

    override suspend fun saveUsersToCache(users: List<User>) {
        userList.clear()
        userList = ArrayList(users)
    }
}