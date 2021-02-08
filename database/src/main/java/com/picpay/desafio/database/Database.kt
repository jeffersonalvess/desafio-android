package com.picpay.desafio.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.database.dao.UserDao
import com.picpay.desafio.database.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
internal abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao
}
