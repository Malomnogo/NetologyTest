package com.malomnogo.netologytest.network

import com.malomnogo.netologytest.model.remote.NetologyDataResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface NetworkService {
    @GET("repo/netology-code/rn-task/master/netology.json")
    fun getNetologyData(): Single<NetologyDataResponse>
}