package com.littlelemon.menu.data

sealed class SortType {
    object Alphabetically : SortType()
    object PriceAsc : SortType()
    object PriceDesc : SortType()
}
