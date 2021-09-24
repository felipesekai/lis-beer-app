package com.sekai.lisbeer.data

import com.sekai.lisbeer.Product

interface LisbeerDataSource {

    fun getAllProducts(): List<Product>
}