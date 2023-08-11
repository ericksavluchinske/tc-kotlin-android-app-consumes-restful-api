package com.example.tckotlinrestfulapi.data.repository.user.datasourceimpl

import com.example.tckotlinrestfulapi.data.db.UserDao
import com.example.tckotlinrestfulapi.data.model.user.User
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserLocalDataSourceImpl(
    private val userDao: UserDao
): UserLocalDataSource {
    override suspend fun getUsersFromDB(): List<User> {
        return userDao.getUsers()
    }

    override suspend fun saveUsersToDB(users: List<User>) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.saveUsers(users)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.deleteAllUsers()
        }
    }
}