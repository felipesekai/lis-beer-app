package com.sekai.lisbeer.ui.home

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

object Teste {
    private var context : Context? = null
    @SuppressLint("StaticFieldLeak")
    fun setContext(context: Context){
        this.context = context
    }
      @SuppressLint("StaticFieldLeak")
      @JvmName("getContext1")
      fun getContext() = context
}