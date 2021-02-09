package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.appModule
import com.picpay.desafio.database.di.databaseModule
import com.picpay.desafio.network.di.networkModule
import com.picpay.desafio.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            printLogger()
            androidContext(this@PicPayApplication)
            modules(
                appModule +
                        databaseModule +
                        networkModule +
                        repositoryModule
            )
        }
    }
}