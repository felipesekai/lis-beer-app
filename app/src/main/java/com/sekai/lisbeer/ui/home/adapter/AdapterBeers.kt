package com.sekai.lisbeer.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.CardItemBeerBinding

class AdapterBeers(val context: Context) : RecyclerView.Adapter<AdapterBeers.ViewHolder>(){
    val list = mutableListOf<String>("hainoken", "budweiser","Stella")

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val name = itemView.findViewById<TextView>(R.id.txt_item_name)
        val evaluation = itemView.findViewById<TextView>(R.id.txt_evaluation)
        val img : ImageView = itemView.findViewById(R.id.iv_item_beer)

        fun bind(s: String) {
            name.text = s
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemBeerBinding.inflate(LayoutInflater.from(context) ,parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}