package com.example.foodcookbook.models

data class RecipeBook(
    var idRecipebook:Int,
    var nameRecipebook: String = "",
    var productPhoto: Int,
    var author: String = "",
    var recipeBook: String = ""

) {
    fun add(product: RecipeBook) {

    }
}