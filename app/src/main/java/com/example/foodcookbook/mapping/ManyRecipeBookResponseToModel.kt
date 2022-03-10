package com.example.foodcookbook.mapping

import com.example.foodcookbook.models.ManyRecipeBookResponse
import com.example.foodcookbook.models.RecipeBook

internal fun ManyRecipeBookResponse.toModel(): MutableList<RecipeBook> {
    val recipeBookList: MutableList<RecipeBook> = mutableListOf()

    recipeBooks.map { RB ->
        recipeBookList.add(
            RecipeBook(
                idRecipebook = RB.idRecipebook,
                nameRecipebook = RB.nameRecipebook,
                productPhoto = RB.productPhoto,
                recipeBook = RB.recipeBook,
                created_at = RB.created_at,
                author = RB.author
            )
        )
    }

    return recipeBookList

}