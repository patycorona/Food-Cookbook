package com.example.foodcookbook.models

import com.google.gson.annotations.SerializedName

class ManyUserAccessResponse {
    @SerializedName("access") val userAccessRequestM:  MutableList<UserAccessRequest>  =  mutableListOf()
}