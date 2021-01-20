package com.malomnogo.netologytest.domain

import com.malomnogo.netologytest.model.ui.NetologyUiData
import com.malomnogo.netologytest.repositories.IDataRepository
import io.reactivex.rxjava3.core.Single

class GetNetologyDataUseCase(private val dataRepository: IDataRepository) :
    BaseUseCase<Single<List<NetologyUiData>>>() {

    override fun execute(): Single<List<NetologyUiData>> = dataRepository.getNetologyData()

}