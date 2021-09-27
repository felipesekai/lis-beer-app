package com.sekai.lisbeer.implementations

import android.util.Log
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.data.LisbeerDataSource
import com.sekai.lisbeer.model.Beer
import com.sekai.lisbeer.model.Categories

class LisbeerDataSourceImplementation(private val myRetrofit: MyRetrofit) : LisbeerDataSource{
    companion object {
        const val TAG = "Repository"
    }

    private val productList = arrayListOf<Product>()
    private val beerList = arrayListOf<Beer>()
    private val categoriesList = arrayListOf<Categories>()
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

    override fun getAllBeers(): List<Beer> {
        val request = myRetrofit.retrofitApi().getBeers().execute()
        if (request.isSuccessful){
            request.body().let{
                if (it != null) {
                    beerList.addAll(it)
                }
            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return beerList
    }

    override fun getAllCategories(): List<Categories> {
        val request = myRetrofit.retrofitApi().getCategories().execute()
        if(request.isSuccessful){
            request.body().let{
                if (it != null) {
                    categoriesList.addAll(it)
                }
            }
        }else{
            request.errorBody().let{
                Log.d(TAG, it.toString())
            }
        }

        return  categoriesList
    }


}