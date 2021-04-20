package com.balditsyn.stackoveflow

import android.app.Application
import com.balditsyn.stackoveflow.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, databaseModule, repositoryModule, viewModelModule))
        }
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }
}

