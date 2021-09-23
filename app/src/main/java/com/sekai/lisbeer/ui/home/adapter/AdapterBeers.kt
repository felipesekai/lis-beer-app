package com.sekai.lisbeer.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.CardItemBeerBinding

class AdapterBeers() : RecyclerView.Adapter<AdapterBeers.ViewHolder>(){
    val list = mutableListOf<String>("heineken", "budweiser","Stella")

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val name = itemView.findViewById<TextView>(R.id.txt_item_name)
        val evaluation = itemView.findViewById<TextView>(R.id.txt_evaluation)
        val img : ImageView = itemView.findViewById(R.id.iv_item_beer)

        fun bind(s: String) {
            name.text = s
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflate = LayoutInflater.from(parent.context)
        val binding = CardItemBeerBinding.inflate(inflate ,parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}