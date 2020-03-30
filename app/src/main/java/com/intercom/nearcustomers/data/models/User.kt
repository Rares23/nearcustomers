package com.intercom.nearcustomers.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "user_id")val id: Int,
    @SerializedName(value = "name")val name: String,
    @SerializedName(value = "latitude")val lat: Double,
    @SerializedName(value = "longitude")val lng: Double
)