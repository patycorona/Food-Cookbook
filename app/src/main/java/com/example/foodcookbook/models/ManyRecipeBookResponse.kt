package com.example.foodcookbook.models

import com.google.gson.annotations.SerializedName

class ManyRecipeBookResponse {

    @SerializedName("recipes") val recipeBooks: MutableList<RecipeBookResponse> = mutableListOf()
}