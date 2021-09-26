package com.sekai.lisbeer.ui.home

import com.sekai.lisbeer.model.Product

object varOrFun {
    private var myList : List<Product> = mutableListOf()


    fun setList(list: List<Product>){
        myList = list
    }
    fun getList(): List<Product> = myList

}