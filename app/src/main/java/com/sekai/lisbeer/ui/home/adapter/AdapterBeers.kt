package com.sekai.lisbeer.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.CardItemBeerBinding
import com.sekai.lisbeer.model.Beer

class AdapterBeers(/*context : Context */) : RecyclerView.Adapter<AdapterBeers.ViewHolder>(){
//    private val list = mutableListOf<String>("heineken", "budweiser","Stella")
    private var listBeers = mutableListOf<Beer>()
    var oneClick : (Beer)->Unit ={}

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val name = itemView.findViewById<TextView>(R.id.txt_item_name)
        val evaluation = itemView.findViewById<TextView>(R.id.txt_evaluation)
        val img : ImageView = itemView.findViewById(R.id.iv_item_beer)
        val card = itemView.findViewById<CardView>(R.id.cardView_beer)

        fun bind(item : Beer) {
//            name.text = s
            name.text = item.name
            evaluation.text = item.evaluation.toString()
//            Glide.with(context).load(item.img).into(img)
            card.setOnClickListener{
                oneClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflate = LayoutInflater.from(parent.context)
        val binding = CardItemBeerBinding.inflate(inflate ,parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(listBeers[position])
    }

    override fun getItemCount(): Int = listBeers.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(lista: MutableList<Beer>){
            listBeers.clear()
            listBeers = lista
            notifyDataSetChanged()
    }

}