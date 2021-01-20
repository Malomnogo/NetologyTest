package com.malomnogo.netologytest.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.schedulers.Schedulers

class RxSchedulersProvider {

    private val mainThreadScheduler: Scheduler by lazy { AndroidSchedulers.mainThread() }

    private val ioScheduler: Scheduler by lazy { Schedulers.io() }

    private val computationScheduler: Scheduler by lazy { Schedulers.computation() }

    fun getIoToMainTransformerCompletable(): CompletableTransformer = CompletableTransformer {
        it
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun getComputationToMainTransformerCompletable(): CompletableTransformer = CompletableTransformer {
        it
            .subscribeOn(computationScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getComputationToMainTransformerSingle(): SingleTransformer<T, T> = SingleTransformer {
        it
            .subscribeOn(computationScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getIoToMainTransformerSingle(): SingleTransformer<T, T> = SingleTransformer {
        it
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getComputationToMainTransformerObservable(): ObservableTransformer<T, T> = ObservableTransformer {
        it
            .subscribeOn(computationScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getIoToMainTransformerObservable(): ObservableTransformer<T, T> = ObservableTransformer {
        it
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
    }


    fun <T> getComputationToMainTransformerFlowable(): FlowableTransformer<T, T> = FlowableTransformer {
        it
            .subscribeOn(computationScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getIoToMainTransformerFlowable(): FlowableTransformer<T, T> = FlowableTransformer {
        it
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getComputationToMainTransformerMaybe(): MaybeTransformer<T, T> = MaybeTransformer {
        it
            .subscribeOn(computationScheduler)
            .observeOn(mainThreadScheduler)
    }

    fun <T> getIoToMainTransformerMaybe(): MaybeTransformer<T, T> = MaybeTransformer {
        it
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
    }
}