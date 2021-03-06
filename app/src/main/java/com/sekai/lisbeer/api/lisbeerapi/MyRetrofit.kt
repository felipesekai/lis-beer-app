package com.sekai.lisbeer.api.lisbeerapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    private val retrofit : Retrofit

    fun LisbeerApi(): LisbeerApi{
        return retrofit.create(LisbeerApi::class.java)
    }
    fun retrofitApi(): LisbeerApi = productProvider().create(LisbeerApi::class.java)
    companion object {
        private const val  BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/"
        var myRetrofit : MyRetrofit? = null

        @get:Synchronized

        val instance: MyRetrofit?
        get() {
            if (myRetrofit == null){
                myRetrofit = MyRetrofit()
            }
            return myRetrofit
        }
    }
    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    private fun productProvider() : Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

}