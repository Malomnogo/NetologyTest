package com.malomnogo.netologytest.model.remote

data class ItemsResponse(
        val id: String,
        val link: String,
        val badge: BadgeResponse,
        val title: String
)