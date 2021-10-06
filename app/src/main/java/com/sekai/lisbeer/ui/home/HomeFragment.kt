package com.sekai.lisbeer.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.databinding.FragmentHomeBinding
import com.sekai.lisbeer.model.Beer
import com.sekai.lisbeer.ui.home.adapter.AdapterBeers
import com.sekai.lisbeer.ui.home.adapter.AdapterCategory
import com.sekai.lisbeer.ui.item.ItemActivity
import com.sekai.lisbeer.ui.item.ItemActivity.Companion.EXTRA

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var context1 : Context

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })

        loading(true)
        initListBeer()
        initListCategory()

        return root
    }

    private fun initListBeer() {
//        activity
        val beers = arrayListOf(
            Beer(1,"Heiniken", 4.4,5.50,""),
            Beer(3,"Budweiser", 4.5,5.60,""),
            Beer(55,"Stella", 4.5,5.80,""),

        )

        val adapterBeers = AdapterBeers()
        adapterBeers.apply {
            updateList(beers)
            oneClick = {
               val intent =  Intent(activity,ItemActivity::class.java)
                intent.putExtra(EXTRA,it)
                startActivity(intent)
            }
        }



           binding.rvListBeers.apply {
//                layoutManager = LinearLayoutManager(activity)
                adapter = adapterBeers
            }



    }

    private fun initListCategory(){
        val adapterCategory  = context?.let { AdapterCategory(it) }
        adapterCategory?.clickListener = {
            startActivity(Intent(activity,ItemActivity::class.java))
        }

        homeViewModel.init()
        homeViewModel.lista.observe(viewLifecycleOwner, { lista->
            if (lista.isNotEmpty()){
                loading(false)
                adapterCategory!!.updateList(lista as ArrayList<Product>)
            }
        })

        binding.rvListFoods.apply {
                adapter = adapterCategory
        }

    }

    private fun loading(isLoading: Boolean){
        binding.progressbarCircular.apply {
            visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    override fun onAttach(context: Context) {
        context1 = context
        super.onAttach(context1)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}