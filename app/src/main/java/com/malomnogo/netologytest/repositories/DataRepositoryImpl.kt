package com.malomnogo.netologytest.repositories

import com.malomnogo.netologytest.model.remote.toUi
import com.malomnogo.netologytest.model.ui.NetologyUiData
import com.malomnogo.netologytest.network.NetworkService
import io.reactivex.rxjava3.core.Single

class DataRepositoryImpl(private val networkService: NetworkService) : IDataRepository {

    override fun getNetologyData(): Single<List<NetologyUiData>> {
        return networkService.getNetologyData().map {
            it.data.map { result -> result.toUi() }
        }
    }

}