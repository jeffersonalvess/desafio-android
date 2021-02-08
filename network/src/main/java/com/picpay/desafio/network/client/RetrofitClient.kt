package com.picpay.desafio.network.client

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.network.webservice.PicPayService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun provideCache(application: Application): Cache {
    val cacheSize = 1024 * 1024 * 10
    return Cache(application.cacheDir, cacheSize.toLong())
}

internal fun provideOkHttp(cache: Cache) =
    OkHttpClient.Builder().cache(cache).build()

internal fun provideGson() =
    GsonBuilder().create()

internal fun provideRetrofit(okHttp: OkHttpClient, gson: Gson) =
    Retrofit.Builder()
        .baseUrl(url)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

internal fun providePicPayService(retrofit: Retrofit) =
    retrofit.create(PicPayService::class.java)

private const val url = "http://careers.picpay.com/tests/mobdev/"