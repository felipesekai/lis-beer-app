package com.sekai.lisbeer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class Categories(
    @SerializedName("id")
    val id: UUID?,
    @SerializedName("name")
    val name: String,
    @SerializedName("evaluation")
    val evaluation: Int = 0
): Parcelable {
}