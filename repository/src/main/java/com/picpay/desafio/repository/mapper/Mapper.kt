package com.picpay.desafio.repository.mapper

interface Mapper<From, To> {
    fun map(from: From): To
}