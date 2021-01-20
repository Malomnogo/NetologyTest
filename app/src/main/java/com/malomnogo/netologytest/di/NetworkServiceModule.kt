package com.malomnogo.netologytest.di

import com.malomnogo.netologytest.network.NetworkService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkServiceModule = module {
    single { get<Retrofit>().create(NetworkService::class.java) }
}