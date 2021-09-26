package com.sekai.lisbeer.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.databinding.FragmentHomeBinding
import com.sekai.lisbeer.ui.home.adapter.AdapterBeers
import com.sekai.lisbeer.ui.home.adapter.AdapterCategory

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
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        loading(true)

        return root
    }

    override fun onResume() {
        super.onResume()
        initListBeer()
        initListCategory()

    }

    private fun initListBeer() {
//        activity

        val adapterBeers = AdapterBeers()


           binding.rvListBeers.apply {
//                layoutManager = LinearLayoutManager(activity)
                adapter = adapterBeers
            }



    }

    private fun initListCategory(){
        val adapterFoods  = context?.let { AdapterCategory(it) }

        homeViewModel.init()
        homeViewModel.lista.observe(this, { lista->
            if (lista.isNotEmpty()){
                loading(false)
                adapterFoods!!.updateList(lista as ArrayList<Product>)
            }
        })

        binding.rvListFoods.apply {
                adapter = adapterFoods
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