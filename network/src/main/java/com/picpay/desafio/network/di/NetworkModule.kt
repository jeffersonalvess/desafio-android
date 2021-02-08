package com.picpay.desafio.network.di

import com.picpay.desafio.network.client.provideCache
import com.picpay.desafio.network.client.provideGson
import com.picpay.desafio.network.client.provideOkHttp
import com.picpay.desafio.network.client.providePicPayService
import com.picpay.desafio.network.client.provideRetrofit
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    // Dependencies for creating PicPayService
    factory { provideCache(androidApplication()) }
    factory { provideOkHttp(get()) }
    factory { provideGson() }
    factory { provideRetrofit(get(), get()) }

    // Provides a singleton instance of PicPayService connection
    single { providePicPayService(get()) }
}
