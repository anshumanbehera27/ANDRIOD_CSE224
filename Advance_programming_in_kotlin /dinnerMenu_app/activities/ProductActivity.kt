package com.littlelemon.menu.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.littlelemon.menu.R
import com.littlelemon.menu.data.ProductItem
import com.littlelemon.menu.ui.screens.ProductDetails

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra(EXTRA_PRODUCT_TITLE_KEY)?:""
        val price = intent.getDoubleExtra(EXTRA_PRODUCT_PRICE_KEY,0.0)
        val category = intent.getStringExtra(EXTRA_PRODUCT_CATEGORY_KEY)?:""
        val image = intent.getIntExtra(EXTRA_PRODUCT_IMAGE_KEY, R.drawable.not_found_image)
        val productItem =
            ProductItem(title, price, category, image)
        setContent { ProductDetails(productItem) }
    }

    companion object {
        const val EXTRA_PRODUCT_TITLE_KEY = "productTitle"
        const val EXTRA_PRODUCT_PRICE_KEY = "productProduce"
        const val EXTRA_PRODUCT_CATEGORY_KEY = "productCategory"
        const val EXTRA_PRODUCT_IMAGE_KEY = "productImage"

        fun start(context: Context, productItem: ProductItem) {
            val intent = Intent(context, ProductActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT_TITLE_KEY, productItem.title)
                putExtra(EXTRA_PRODUCT_PRICE_KEY, productItem.price)
                putExtra(EXTRA_PRODUCT_CATEGORY_KEY, productItem.category)
                putExtra(EXTRA_PRODUCT_IMAGE_KEY, productItem.image)
            }
            context.startActivity(intent)
        }
    }
}