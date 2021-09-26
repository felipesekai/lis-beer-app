package com.sekai.lisbeer.ui.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sekai.lisbeer.R
import com.sekai.lisbeer.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {
    private val binding by lazy { ActivityItemBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initToolbar()
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