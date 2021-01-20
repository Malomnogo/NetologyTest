package com.malomnogo.netologytest

import android.app.Application
import com.malomnogo.netologytest.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                    listOf(
                            domainModule,
                            networkModule,
                            viewModelModule,
                            repositoryModule,
                            networkServiceModule,
                            useCaseModule
                    )
            )
        }
    }

}