package com.sekai.lisbeer

import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.data.Repository
import com.sekai.lisbeer.implementations.LisbeerDataSourceImplementation
import com.sekai.lisbeer.model.Beer
import com.sekai.lisbeer.model.Categories
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
    val myRetrofit = MyRetrofit()
    val dataSource =  LisbeerDataSourceImplementation(myRetrofit)
    val repository = Repository(dataSource)
    val produtcListCaseUse = ProductListUseCase(repository)
    val lista : List<Product> = produtcListCaseUse.invoke() as ArrayList
    val listaBeer : List<Beer> = produtcListCaseUse.invokeBeers()
    val listaCategories : List<Categories> = produtcListCaseUse.invokeCategories()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun getListaAPi(){

        val testelista = arrayListOf<Product>()

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
    @Test
    fun getListaBeerAPi(){

        val testelista = arrayListOf<Beer>()
        val lista2 : ArrayList<Beer> = ArrayList()
        lista2.addAll(listaBeer)
        assertNotEquals(testelista, listaBeer)
        assertEquals(lista2, listaBeer)

    }
    @Test
    fun getListaCategoriesAPi(){
        val testelista = arrayListOf<Categories>()
        val lista2 : ArrayList<Categories> = ArrayList()
        lista2.addAll(listaCategories)
        listaCategories.forEach {
            testelista.add(Categories(
                0,
                "",
                0,
            )
            )
        }
        assertNotEquals(testelista, listaCategories)
        assertEquals(testelista.size, listaCategories.size)
        assertEquals(lista2, listaCategories)

    }
}