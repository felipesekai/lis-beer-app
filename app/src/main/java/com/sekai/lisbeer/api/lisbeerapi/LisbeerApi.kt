package com.sekai.lisbeer.api.lisbeerapi

import com.sekai.lisbeer.model.Beer
import com.sekai.lisbeer.model.Categories
import com.sekai.lisbeer.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface LisbeerApi {
    @GET("androidweb.php")
// retornar uma lista com os objetos da api
    fun getProductApi(): Call<List<Product>>

    @GET("/beers")
    fun getBeers(): Call<List<Beer>>

    @GET("/categories")
    fun getCategories(): Call<List<Categories>>
}