package com.example.tckotlinrestfulapi.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tckotlinrestfulapi.data.model.user.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUsers(users: List<User>)

    @Query("DELETE FROM users_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM users_table")
    suspend fun getUsers(): List<User>
}