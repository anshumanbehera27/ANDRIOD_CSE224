package com.littlelemon.menu.domain

import com.littlelemon.menu.R
import com.littlelemon.menu.data.ProductItem

object ProductsHelper {
    const val DESSERT_CATEGORY = "Dessert"
    const val FOOD_CATEGORY = "Food"
    const val DRINKS_CATEGORY = "Drinks"

    val productsList = mutableListOf(
        ProductItem("Black tea", 3.00, DRINKS_CATEGORY, R.drawable.black_tea),
        ProductItem("Green tea", 3.00, DRINKS_CATEGORY, R.drawable.green_tea),
        ProductItem("Espresso", 5.00, DRINKS_CATEGORY, R.drawable.espresso),
        ProductItem("Cappuccino", 8.00, DRINKS_CATEGORY, R.drawable.cappuccino),
        ProductItem("Latte", 8.00, DRINKS_CATEGORY, R.drawable.latte),
        ProductItem("Mocha", 10.00, DRINKS_CATEGORY, R.drawable.mocha),
        ProductItem("Boeuf bourguignon", 15.00, FOOD_CATEGORY, R.drawable.boeuf_bourguignon),
        ProductItem("Bouillabaisse", 20.00, FOOD_CATEGORY, R.drawable.bouillabaisse),
        ProductItem("Lasagna", 15.00, FOOD_CATEGORY, R.drawable.lasagna),
        ProductItem("Onion soup", 12.00, FOOD_CATEGORY, R.drawable.onion_soup),
        ProductItem("Salmon en papillote", 25.00, FOOD_CATEGORY, R.drawable.salmon_en_papillote),
        ProductItem("Quiche Lorraine", 17.00, DESSERT_CATEGORY, R.drawable.quiche_lorraine),
        ProductItem("Custard tart", 14.00, DESSERT_CATEGORY, R.drawable.custard_tart),
        ProductItem("Croissant", 7.00, DESSERT_CATEGORY, R.drawable.croissant),
    )
}