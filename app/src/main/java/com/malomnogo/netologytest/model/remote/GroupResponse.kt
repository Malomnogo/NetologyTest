package com.malomnogo.netologytest.model.remote

data class GroupResponse(
        val id: String,
        val link: String,
        val badge: BadgeResponse,
        val items: List<ItemsResponse>,
        val title: String
)