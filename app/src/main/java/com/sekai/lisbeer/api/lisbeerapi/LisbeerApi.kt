package com.sekai.lisbeer.api.lisbeerapi

import com.sekai.lisbeer.Product
import retrofit2.Call
import retrofit2.http.GET

interface LisbeerApi {
    @GET("androidweb.php")
// retornar uma lista com os objetos da api
    fun getProductApi(): Call<List<Product>>

}