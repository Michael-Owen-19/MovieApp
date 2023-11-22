package com.michael.movieapp

import android.app.Application
import com.michael.movieapp.core.di.databaseModule
import com.michael.movieapp.core.di.networkModule
import com.michael.movieapp.core.di.repositoryModule
import com.michael.movieapp.di.useCaseModule
import com.michael.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}