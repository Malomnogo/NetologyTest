package com.malomnogo.netologytest.model.remote

data class DirectionResponse(
    val id: String,
    val link: String,
    val badge: BadgeResponse,
    val title: String
)
