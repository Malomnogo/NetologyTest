package com.malomnogo.netologytest.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.malomnogo.netologytest.utils.Event
import com.malomnogo.netologytest.utils.Status
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val binds = CompositeDisposable()

    private val _state = MutableLiveData<Event<Status>>()

    val state: LiveData<Event<Status>> = _state


    open fun onHandleError(throwable: Throwable) {
        Log.d("BASE_VIEW_MODEL_ERROR", throwable.message.toString())
        _state.value = Event(Status.ERROR)
    }

    open fun onHandleSuccess() {
        _state.value = Event(Status.SUCCESS)
    }

    fun addDisposable(disposable: Disposable) {
        binds.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        binds.dispose()
    }
}