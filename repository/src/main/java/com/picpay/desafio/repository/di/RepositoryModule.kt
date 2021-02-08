package com.picpay.desafio.repository.di

import com.picpay.desafio.repository.UserRepository
import com.picpay.desafio.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory <UserRepository> { UserRepositoryImpl(get(), get()) }
}
