package com.malomnogo.netologytest.di

import com.malomnogo.netologytest.domain.GetNetologyDataUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetNetologyDataUseCase(dataRepository = get()) }
}