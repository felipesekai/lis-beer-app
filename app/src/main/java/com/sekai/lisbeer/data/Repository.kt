package com.sekai.lisbeer.data

class Repository(private val lisbeerDataSource: LisbeerDataSource){

        fun getAllProductsFromDataSource() = lisbeerDataSource.getAllProducts()
        fun getAllBeersFromDataSource() = lisbeerDataSource.getAllBeers()
        fun getAllCategoriesFromDataSource() = lisbeerDataSource.getAllCategories()

}