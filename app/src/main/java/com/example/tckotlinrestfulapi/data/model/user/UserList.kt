package com.example.tckotlinrestfulapi.data.model.user


import com.example.tckotlinrestfulapi.data.model.user.User
import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("users")
    val users: List<User>
)