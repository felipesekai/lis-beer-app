package com.sekai.lisbeer.model

import com.google.gson.annotations.SerializedName

class Product( @SerializedName("id")
               val id: String,

               @SerializedName("imageurl")
               val imageurl: String,

               @SerializedName("views")
               val views: String,
               @SerializedName("download")
               val downloads: String,) {

}