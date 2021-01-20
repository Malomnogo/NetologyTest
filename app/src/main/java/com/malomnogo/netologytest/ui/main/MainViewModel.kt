package com.malomnogo.netologytest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.malomnogo.netologytest.domain.GetNetologyDataUseCase
import com.malomnogo.netologytest.model.ui.NetologyUiData
import com.malomnogo.netologytest.ui.base.BaseViewModel
import com.malomnogo.netologytest.utils.RxSchedulersProvider
import com.malomnogo.netologytest.utils.bindTo

class MainViewModel(
    private val rxSchedulersProvider: RxSchedulersProvider,
    private val getNetologyDataUseCase: GetNetologyDataUseCase
) : BaseViewModel() {

    private val _dataUi: MutableLiveData<List<NetologyUiData>> = MutableLiveData()
    val dataUi: LiveData<List<NetologyUiData>> = _dataUi

    init {
        getData()
    }

    private fun getData() {
        getNetologyDataUseCase.execute()
            .compose(rxSchedulersProvider.getComputationToMainTransformerSingle())
            .subscribe(::onGetDataSuccess, ::onGetDataError)
            .bindTo(this)
    }

    private fun onGetDataError(throwable: Throwable) {
        onHandleError(throwable)
    }

    private fun onGetDataSuccess(listNetologyData: List<NetologyUiData>) {
        _dataUi.value = listNetologyData
        onHandleSuccess()
    }
}