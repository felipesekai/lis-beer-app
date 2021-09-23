package com.sekai.lisbeer.ui.home

import android.content.Context
import android.widget.Toast
import com.sekai.lisbeer.Product
import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object varOrFun {
    private var myList : List<Product> = mutableListOf()


    fun setList(list: List<Product>){
        myList = list
    }
    fun getList(): List<Product> = myList

}