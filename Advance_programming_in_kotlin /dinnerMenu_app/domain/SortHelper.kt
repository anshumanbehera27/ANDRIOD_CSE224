package com.littlelemon.menu.domain

import com.littlelemon.menu.data.ProductItem
import com.littlelemon.menu.data.SortType

class SortHelper {

    fun sortProducts(type: SortType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            SortType.Alphabetically -> productsList.sortAlphabetically()
            SortType.PriceAsc -> productsList.sortAscending()
            SortType.PriceDesc -> productsList.sortDescending()
        }
    }

    private fun List<ProductItem>.sortAlphabetically(): List<ProductItem> {
        return sortedBy { it.title }
    }

    private fun List<ProductItem>.sortAscending(): List<ProductItem> {
        return sortedBy { it.price }
    }

    private fun List<ProductItem>.sortDescending(): List<ProductItem> {
        return sortedBy { it.price }.reversed()
    }

}