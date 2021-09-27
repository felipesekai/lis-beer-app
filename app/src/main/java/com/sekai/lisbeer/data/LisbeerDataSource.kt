package com.sekai.lisbeer.data

import com.sekai.lisbeer.model.Beer
import com.sekai.lisbeer.model.Categories
import com.sekai.lisbeer.model.Product

interface LisbeerDataSource {

    fun getAllProducts(): List<Product>
    fun getAllBeers(): List<Beer>
    fun getAllCategories(): List<Categories>
}