package com.example.foodcookbook.models

import com.google.gson.annotations.SerializedName

class ManyRecipeBookResponse {
    @SerializedName("product") val products: MutableList<RecipeBookResponse> = mutableListOf()
}