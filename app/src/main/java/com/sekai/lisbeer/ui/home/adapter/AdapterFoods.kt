package com.sekai.lisbeer.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.CardItemBeerBinding
import com.sekai.lisbeer.databinding.CardItensFoodsBinding

class AdapterFoods : RecyclerView.Adapter<AdapterFoods.ViewHolder>(){
    val list = mutableListOf<String>("EXEMPLE 1", "EXEMPLE 2","EXEMPLE 3")

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val title = itemView.findViewById<TextView>(R.id.txt_cif_item_title)
        val img : ImageView = itemView.findViewById(R.id.imgView_cif_img)

        fun bind(s: String) {
            title.text = s
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflate = LayoutInflater.from(parent.context)
        val binding = CardItensFoodsBinding.inflate(inflate ,parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}