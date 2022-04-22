package com.android.challengeroneapp.data.db.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CartEntity(
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    val title: String? = null,
    val price: String? = null,
    val category: String? = null,
    val description: String? = null,
    val image: String? = null
)