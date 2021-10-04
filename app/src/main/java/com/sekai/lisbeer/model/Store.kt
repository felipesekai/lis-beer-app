package com.sekai.lisbeer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class Store(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("evaluation")
    val evaluation: Double = 0.0,
    @SerializedName("photoUrl")
    val photoUrl: String,
):Parcelable
{
}