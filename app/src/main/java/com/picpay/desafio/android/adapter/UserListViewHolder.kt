package com.picpay.desafio.android.adapter

import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.database.entities.User

class UserListViewHolder(private val binding: ListItemUserBinding) : UserAdapterViewHolder(binding) {

    fun bind(user: User) {
        binding.user = user
        binding.executePendingBindings()
    }
}