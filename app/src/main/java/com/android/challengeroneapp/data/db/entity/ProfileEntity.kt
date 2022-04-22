package com.android.challengeroneapp.data.db.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ProfileEntity(
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val userName: String? = null,
    val password: String? = null,
    val gender: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val pincode: String? = null,
    val city: String? = null,
    val country: String? = null,
    val lat: String? = null,
    val longVal: String? = null
)