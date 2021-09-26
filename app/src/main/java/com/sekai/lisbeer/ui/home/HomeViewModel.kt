package com.sekai.lisbeer.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.data.Repository
import com.sekai.lisbeer.implementations.LisbeerDataSourceImplementation
import com.sekai.lisbeer.usecase.ProductListUseCase

class HomeViewModel : ViewModel() {
    private val myRetrofit = MyRetrofit()
    private val dataSource =  LisbeerDataSourceImplementation(myRetrofit)
    private val repository = Repository(dataSource)
    private val produtcListCaseUse = ProductListUseCase(repository)

    companion object {
        const val TAG = "ProductRepository"
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var productList = MutableLiveData<List<Product>>()
    val lista : LiveData<List<Product>>
        get() =
            productList

    fun init(){
        getAllProducts()
    }

    private fun getAllProducts() {
        Thread {
            try {
                productList.postValue(produtcListCaseUse.invoke())
            }catch (exception: Exception) {
                Log.d(TAG, exception.message.toString())
            }

        }.start()
    }
}