package com.sekai.lisbeer.implementations

import android.util.Log
import com.sekai.lisbeer.Product
import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.data.LisbeerDataSource

class LisbeerDataSourceImplementation(private val myRetrofit: MyRetrofit) : LisbeerDataSource{
    companion object {
        const val TAG = "Repository"
    }

    private val productList = arrayListOf<Product>()
    override fun getAllProducts(): List<Product> {
        val request =myRetrofit.retrofitApi().getProductApi().execute()

        if(request.isSuccessful){
            request.body().let{
                if (it != null) {
                    productList.addAll(it)
                }else{
                    request.errorBody()?.let {
                        Log.d(TAG, it.toString())
                    }
                }
            }
        }
        return productList
    }


}