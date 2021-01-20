package com.malomnogo.netologytest.di

import com.malomnogo.netologytest.repositories.DataRepositoryImpl
import com.malomnogo.netologytest.repositories.IDataRepository
import org.koin.dsl.module

val repositoryModule = module {


    single<IDataRepository> { DataRepositoryImpl(networkService = get()) }

}