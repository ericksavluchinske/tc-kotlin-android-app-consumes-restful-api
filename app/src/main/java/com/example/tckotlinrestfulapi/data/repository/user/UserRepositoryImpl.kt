package com.example.tckotlinrestfulapi.data.repository.user

import android.util.Log
import com.example.tckotlinrestfulapi.data.model.user.User
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserCacheDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserLocalDataSource
import com.example.tckotlinrestfulapi.data.repository.user.datasource.UserRemoteDataSource
import com.example.tckotlinrestfulapi.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val userCacheDataSource: UserCacheDataSource
): UserRepository {
    override suspend fun getUsers(): List<User>? {
        return getUsersFromCache()
    }

    override suspend fun updateUsers(): List<User>? {
        val newListOfUsers = getUsersFromAPI()
        userLocalDataSource.clearAll()
        userLocalDataSource.saveUsersToDB(newListOfUsers)
        userCacheDataSource.saveUsersToCache(newListOfUsers)
        return newListOfUsers
    }

    suspend fun getUsersFromCache(): List<User>{
        lateinit var userList: List<User>
        try {
            userList = userCacheDataSource.getUsersFromCache()
        }catch (exception: Exception){
            Log.i("REPO_CACHE", exception.message.toString())
        }

        if (userList.size > 0){
            return userList
        }else{
            userList = getUsersFromDB()
            userCacheDataSource.saveUsersToCache(userList)
        }
        return userList
    }

    suspend fun getUsersFromDB(): List<User>{
        lateinit var userList: List<User>
        try {
            userList = userLocalDataSource.getUsersFromDB()
        }catch (exception: Exception){
            Log.i("REPO_LOCAL", exception.message.toString())
        }
        if (userList.size>0){
            return userList
        }else{
            userList = getUsersFromAPI()
            userLocalDataSource.saveUsersToDB(userList)
        }

        return userList
    }

    suspend fun getUsersFromAPI(): List<User>{
        lateinit var userList: List<User>
        try {
            val response = userRemoteDataSource.getUsers()
            val body = response.body()
            if (body != null){
                userList = body.users
            }
        }catch (exception: Exception){
            Log.i("REPO_REMOTE", exception.message.toString())
        }
        return userList
    }

}