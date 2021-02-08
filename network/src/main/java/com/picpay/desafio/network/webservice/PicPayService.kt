package com.picpay.desafio.network.webservice

import com.picpay.desafio.network.dto.User
import retrofit2.Call
import retrofit2.http.GET


interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<User>
}