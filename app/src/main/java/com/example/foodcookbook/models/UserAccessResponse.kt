package com.example.foodcookbook.models

import com.google.gson.annotations.SerializedName

data class UserAccessResponse(
    @SerializedName("result") val result:UserResult = UserResult()
)
