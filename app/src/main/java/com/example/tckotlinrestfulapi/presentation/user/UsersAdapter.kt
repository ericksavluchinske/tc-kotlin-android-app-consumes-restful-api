package com.example.tckotlinrestfulapi.presentation.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tckotlinrestfulapi.R
import com.example.tckotlinrestfulapi.data.model.user.User
import com.example.tckotlinrestfulapi.databinding.ListItemBinding

class UsersAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val userList = ArrayList<User>()

    fun setList(users: List<User>){
        userList.clear()
        userList.addAll(users)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }
}

class MyViewHolder(val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

    fun bind(user: User){
        binding.tvName.text = user.name
        binding.tvEmail.text = user.email
        binding.tvAge.text = user.age.toString()
        binding.tvId.text = user.id.toString()
    }
}