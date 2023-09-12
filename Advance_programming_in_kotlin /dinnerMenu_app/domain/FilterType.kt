package com.littlelemon.menu.domain

sealed class FilterType {
    object All : FilterType()
    object Drinks : FilterType()
    object Food : FilterType()
    object Dessert : FilterType()
}
