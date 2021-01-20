package com.malomnogo.netologytest.utils

import com.malomnogo.netologytest.ui.base.BaseViewModel
import io.reactivex.rxjava3.disposables.Disposable

fun Disposable.bindTo(vm: BaseViewModel){
    vm.addDisposable(this)
}