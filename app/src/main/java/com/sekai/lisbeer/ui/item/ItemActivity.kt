package com.sekai.lisbeer.ui.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sekai.lisbeer.databinding.ActivityItemBinding
import com.sekai.lisbeer.model.Beer

class ItemActivity : AppCompatActivity() {
    private val binding by lazy { ActivityItemBinding.inflate(layoutInflater) }
    companion object {
        const val EXTRA = "ITEMCLICK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolbar()
            val item = intent.getParcelableExtra<Beer>(EXTRA)
           if (verifyIsNotNull(item)){
                fillFields(item)
           }
    }

    private fun fillFields(item: Beer?) {
        var quant = 0
        binding.apply {
            itemNameIA.text = item!!.name
            itemStarsIA.text = item.evaluation.toString()
            titleQuantidadeIA.text = "Quantidade (${quant})"
            itemPriceIA.text ="Preço: ${item.price}0"
            btnPlusIA.setOnClickListener {
                quant++
                titleQuantidadeIA.text = "Quantidade (${quant})"

            }
            btnMinusIA.setOnClickListener {
                if (quant>0){
                    quant--
                titleQuantidadeIA.text = "Quantidade (${quant})"
                }
            }

        }

    }

    private fun verifyIsNotNull(item: Beer?): Boolean {
//        if (item != null) {
//            return true
//        }else return false
       return item != null
    }

    private fun initToolbar() {
        val toolbar = binding.toolbarItem
        toolbar.title = ""
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}