package com.sekai.lisbeer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class Beer(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("evaluation")
    val evaluation: String,
    @SerializedName("img")
    val img: String
) : Parcelable{
}