package com.malomnogo.netologytest.di

import com.malomnogo.netologytest.utils.RxSchedulersProvider
import org.koin.dsl.module

val domainModule = module {
    single { RxSchedulersProvider() }
}