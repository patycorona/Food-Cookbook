package com.example.foodcookbook.models

import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    @SerializedName("first_name") val firstName: String = "",
    @SerializedName("last_name") val lastName: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("birth_date") val birthDate: String = ""
)
