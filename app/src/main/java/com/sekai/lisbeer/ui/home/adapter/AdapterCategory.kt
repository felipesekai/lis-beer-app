package com.sekai.lisbeer.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sekai.lisbeer.model.Product
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.CardItensCategoryBinding


class AdapterCategory (val context: Context) : RecyclerView.Adapter<AdapterCategory.ViewHolder>(){
   private var list : ArrayList<Product> = arrayListOf()
    var clickListener: (Product) -> Unit = {}

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val title = itemView.findViewById<TextView>(R.id.txt_cif_item_title)
        val img : ImageView = itemView.findViewById(R.id.imgView_cif_img)
        val card = itemView.findViewById<CardView>(R.id.cardView_itemCategory)

        fun bind(item : Product) {
            title.text = item.id
            Glide.with(context).load(item.imageurl).into(img)
            card.setOnClickListener {
                clickListener(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflate = LayoutInflater.from(parent.context)
        val binding = CardItensCategoryBinding.inflate(inflate ,parent, false)
        return ViewHolder(binding.root)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(list[position])



    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(lista: ArrayList<Product>){
        list.clear()
        list.addAll(lista)
        notifyDataSetChanged()
    }

}