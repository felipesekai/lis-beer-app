package com.sekai.lisbeer

import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.data.Repository
import com.sekai.lisbeer.implementations.LisbeerDataSourceImplementation
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.usecase.ProductListUseCase
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun getListaAPi(){
        val myRetrofit = MyRetrofit()
        val dataSource =  LisbeerDataSourceImplementation(myRetrofit)
        val repository = Repository(dataSource)
        val produtcListCaseUse = ProductListUseCase(repository)
        val testelista = arrayListOf<Product>()
        val lista : List<Product> = produtcListCaseUse.invoke() as ArrayList
        val lista2 : ArrayList<Product> = ArrayList()
        lista2.addAll(lista)
        lista.forEach {
            testelista.add(Product(
                "",
                "",
                "",
                "",
            )
            )
        }
        assertNotEquals(testelista, lista)
        assertEquals(testelista.size, lista.size)
        assertEquals(dataSource.getAllProducts().size, lista.size)

    }
}