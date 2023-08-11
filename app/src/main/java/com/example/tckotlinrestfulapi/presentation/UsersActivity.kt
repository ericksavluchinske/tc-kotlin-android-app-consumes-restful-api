package com.example.tckotlinrestfulapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tckotlinrestfulapi.R
import com.example.tckotlinrestfulapi.databinding.ActivityUsersBinding
import com.example.tckotlinrestfulapi.presentation.user.UsersViewModel
import com.example.tckotlinrestfulapi.presentation.user.UsersViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: UsersViewModelFactory
    private lateinit var usersViewModel: UsersViewModel
    private lateinit var binding: ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        usersViewModel = ViewModelProvider(this, factory)
            .get(UsersViewModel::class.java)
    }
}