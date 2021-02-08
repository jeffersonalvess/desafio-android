package com.picpay.desafio.repository

import androidx.lifecycle.LiveData
import com.picpay.desafio.database.entities.User

interface UserRepository {

    fun getUsers(): LiveData<List<User>>

    suspend fun refresh()
}