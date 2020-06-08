package com.ericampire.android.cartmanager.app

import android.app.Application
import com.ericampire.android.cartmanager.app.di.databaseModule
import com.ericampire.android.cartmanager.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule, viewModelModule)
        }
    }
}