package com.example.tckotlinrestfulapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tckotlinrestfulapi.R
import com.example.tckotlinrestfulapi.databinding.ActivityUsersBinding
import com.example.tckotlinrestfulapi.presentation.user.FifthRowUsersAdapter
import com.example.tckotlinrestfulapi.presentation.user.FourthRowUsersAdapter
import com.example.tckotlinrestfulapi.presentation.user.SecondRowUsersAdapter
import com.example.tckotlinrestfulapi.presentation.user.ThirdRowUsersAdapter
import com.example.tckotlinrestfulapi.presentation.user.UsersAdapter
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
    private lateinit var adapter: UsersAdapter
    private lateinit var adapterSecondRow: SecondRowUsersAdapter
    private lateinit var adapterThirdRow: ThirdRowUsersAdapter
    private lateinit var adapterFourthRow: FourthRowUsersAdapter
    private lateinit var adapterFifthRow: FifthRowUsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        usersViewModel = ViewModelProvider(this, factory)
            .get(UsersViewModel::class.java)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        initRecyclerView()
    }

    private fun initRecyclerView(){

        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapter = UsersAdapter()
        binding.usersRecyclerView.adapter = adapter

        binding.rvSecondRow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterSecondRow = SecondRowUsersAdapter()
        binding.rvSecondRow.adapter = adapterSecondRow

        binding.rvThirdRow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterThirdRow = ThirdRowUsersAdapter()
        binding.rvThirdRow.adapter = adapterThirdRow

        binding.rvFourthRow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterFourthRow = FourthRowUsersAdapter()
        binding.rvFourthRow.adapter = adapterFourthRow

        binding.rvFifthRow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        adapterFifthRow = FifthRowUsersAdapter()
        binding.rvFifthRow.adapter = adapterFifthRow

        displayUsers()
    }

    private fun displayUsers(){
        binding.usersProgressBar.visibility = View.VISIBLE
        val responseLiveData = usersViewModel.getUsers()
        responseLiveData.observe(this, Observer {
            if (it != null){
                val firstRow = it.slice(0..9)
                val secondRow = it.slice(10..19)
                val thirdRow = it.slice(20..29)
                val fourthRow = it.slice(30..39)
                val fifthRow = it.slice(40..49)

                adapter.setList(firstRow)
                adapter.notifyDataSetChanged()

                adapterSecondRow.setList(secondRow)
                adapterSecondRow.notifyDataSetChanged()

                adapterThirdRow.setList(thirdRow)
                adapterThirdRow.notifyDataSetChanged()

                adapterFourthRow.setList(fourthRow)
                adapterFourthRow.notifyDataSetChanged()

                adapterFifthRow.setList(fifthRow)
                adapterFifthRow.notifyDataSetChanged()

                binding.usersProgressBar.visibility = View.GONE
            }else{
                binding.usersProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateUsers()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateUsers(){
        binding.usersProgressBar.visibility = View.VISIBLE
        val response = usersViewModel.updateUsers()
        response.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.usersProgressBar.visibility = View.GONE
            }else{
                binding.usersProgressBar.visibility = View.GONE
            }
        })
    }
}