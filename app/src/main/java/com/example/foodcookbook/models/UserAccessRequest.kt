package com.example.foodcookbook.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class UserAccessRequest (
    @SerializedName("user_id") val userid: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("password") val password: String = ""
)

