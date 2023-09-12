package com.littlelemon.menu.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.MenuCompat
import com.littlelemon.menu.ProductsGrid
import com.littlelemon.menu.R
import com.littlelemon.menu.data.ProductItem
import com.littlelemon.menu.data.Products
import com.littlelemon.menu.data.SortType
import com.littlelemon.menu.domain.FilterHelper
import com.littlelemon.menu.domain.FilterType
import com.littlelemon.menu.domain.ProductsHelper
import com.littlelemon.menu.domain.ProductsWarehouse
import com.littlelemon.menu.domain.SortHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    private val productsState: MutableStateFlow<Products> =
        MutableStateFlow(Products(emptyList()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProductsWarehouse.addProductList(ProductsHelper.productsList)
        productsState.value = Products(ProductsWarehouse.getAllProducts())
        setContent { InitUI() }
    }

    @Composable
    fun InitUI() {
        val products by productsState.collectAsState()
        ProductsGrid(products = products) { productItem -> startProductActivity(productItem) }
    }

    private fun startProductActivity(productItem: ProductItem) {
        ProductActivity.start(this, productItem)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.products_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu, true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == R.id.sorting) {
            val type = when (item.itemId) {
                R.id.sort_a_z -> SortType.Alphabetically
                R.id.sort_price_asc -> SortType.PriceAsc
                R.id.sort_price_desc -> SortType.PriceDesc
                else -> SortType.Alphabetically
            }
            productsState.update {
                Products(
                    SortHelper().sortProducts(
                        type,
                        ProductsWarehouse.getAllProducts()
                    )
                )
            }
        } else if (item.groupId == R.id.filter) {
            val type = when (item.itemId) {
                R.id.filter_all -> FilterType.All
                R.id.filter_drinks -> FilterType.Drinks
                R.id.filter_food -> FilterType.Food
                R.id.filter_dessert -> FilterType.Dessert
                else -> FilterType.All
            }
            productsState.update {
                Products(
                    FilterHelper().filterProducts(
                        type,
                        ProductsWarehouse.getAllProducts()
                    )
                )
            }
        }
        return true
    }
}