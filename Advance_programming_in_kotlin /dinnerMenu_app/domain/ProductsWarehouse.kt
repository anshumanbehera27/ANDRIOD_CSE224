package com.littlelemon.menu.domain

import com.littlelemon.menu.data.ProductItem

object ProductsWarehouse {

    private var list = mutableListOf<ProductItem>()

    fun addProductItem( item: ProductItem) {
        list.add(item)
    }

    fun addProductList( productList: List<ProductItem>) {
        list.addAll(productList)
    }

    fun getAllProducts() = list

}