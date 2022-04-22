package com.android.challengeroneapp.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CategoryResponse(
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image")
    val image: String? = null
)