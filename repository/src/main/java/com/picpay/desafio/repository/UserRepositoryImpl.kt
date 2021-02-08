package com.picpay.desafio.repository

import com.picpay.desafio.database.dao.UserDao
import com.picpay.desafio.network.webservice.PicPayService
import com.picpay.desafio.repository.mapper.UserMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class UserRepositoryImpl(
    private val picPayService: PicPayService,
    private val userDao: UserDao,
): UserRepository {

    private val userData by lazy { userDao.findAll() }

    private val userMapper = UserMapper()

    override fun getUsers() = userData

    override suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val users = picPayService.getUsers()
            userDao.add(userMapper.map(users))
        }
    }
}
