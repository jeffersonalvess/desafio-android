package com.picpay.desafio.android

class ExampleService(
    private val service: com.picpay.desafio.rest.PicPayService
) {

    fun example(): List<User> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}