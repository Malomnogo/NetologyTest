package com.malomnogo.netologytest.repositories

import com.malomnogo.netologytest.model.ui.NetologyUiData
import io.reactivex.rxjava3.core.Single

interface IDataRepository {
    fun getNetologyData(): Single<List<NetologyUiData>>
}