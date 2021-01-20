package com.malomnogo.netologytest.di

import com.malomnogo.netologytest.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(rxSchedulersProvider = get(), getNetologyDataUseCase = get()) }
}
