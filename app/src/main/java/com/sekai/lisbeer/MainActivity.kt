package com.sekai.lisbeer

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sekai.lisbeer.api.lisbeerapi.MyRetrofit
import com.sekai.lisbeer.databinding.ActivityMainBinding
import com.sekai.lisbeer.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_user
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        val list : ArrayList<Product> = getData() as ArrayList<Product>
//        setList(list)


    }


    private fun initToolbar() {
        val toolbar = binding.includeToolbar.root
        setSupportActionBar(toolbar)

    }

    private fun getData(): List<Product> {
        var list = arrayListOf<Product>()

        val call : Call<List<Product>> =
            MyRetrofit.instance?.LisbeerApi()?.getProductApi()?.execute() as Call<List<Product>>


        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                list.addAll(response.body()?.toList() as ArrayList<Product>)
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
        return list
    }





    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_car, menu)
        return super.onCreateOptionsMenu(menu)
    }
}