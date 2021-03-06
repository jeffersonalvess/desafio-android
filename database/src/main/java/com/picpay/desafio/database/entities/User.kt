package com.picpay.desafio.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey val id: Int,
    val image: String,
    val name: String,
    val username: String
)
