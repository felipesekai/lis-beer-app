package com.sekai.lisbeer.data

class Repository(private val lisbeerDataSource: LisbeerDataSource){

        fun getAllProductsFromDataSource() = lisbeerDataSource.getAllProducts()
}