package com.android.challengeroneapp.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailsResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("name")
    val name: UserName? = null,
    @SerializedName("address")
    val address: Address? = null,
    @SerializedName("phone")
    val phone: String? = null
)

data class UserName(
    @SerializedName("firstname")
    val firstName: String? = null,
    @SerializedName("lastname")
    val lastName: String? = null,
)

data class Address(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("street")
    val street: String? = null,
    @SerializedName("number")
    val number: String? = null,
    @SerializedName("zipcode")
    val zipcode: String? = null,
    @SerializedName("geolocation")
    val geolocation: Geolocation? = null
)

data class Geolocation(
    @SerializedName("lat")
    val latitude: String? = null,
    @SerializedName("long")
    val longitude: String? = null,
)