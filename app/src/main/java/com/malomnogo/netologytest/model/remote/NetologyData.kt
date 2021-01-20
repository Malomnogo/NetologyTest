package com.malomnogo.netologytest.model.remote

import com.malomnogo.netologytest.model.ui.NetologyUiData

data class NetologyData(
    val groups: List<GroupResponse>,
    val direction: DirectionResponse
)

fun NetologyData.toUi() : NetologyUiData {
    var count = 0
    for (group in groups) {
        count += group.items.size
    }
    return NetologyUiData(direction.title, count)
}