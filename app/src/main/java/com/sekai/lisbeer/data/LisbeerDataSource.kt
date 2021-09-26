package com.sekai.lisbeer.data

import com.sekai.lisbeer.model.Product

interface LisbeerDataSource {

    fun getAllProducts(): List<Product>
}