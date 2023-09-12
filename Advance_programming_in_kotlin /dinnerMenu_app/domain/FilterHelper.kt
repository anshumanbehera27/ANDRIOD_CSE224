package com.littlelemon.menu.domain

import com.littlelemon.menu.data.ProductItem
import com.littlelemon.menu.domain.ProductsHelper.DESSERT_CATEGORY
import com.littlelemon.menu.domain.ProductsHelper.DRINKS_CATEGORY
import com.littlelemon.menu.domain.ProductsHelper.FOOD_CATEGORY

class FilterHelper {

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList

            FilterType.Dessert ->
                productsList.filter { it.category == DESSERT_CATEGORY }


            FilterType.Drinks ->
                productsList.filter { it.category == DRINKS_CATEGORY }

            FilterType.Food ->
                productsList.filter { it.category == FOOD_CATEGORY }
        }
    }

}