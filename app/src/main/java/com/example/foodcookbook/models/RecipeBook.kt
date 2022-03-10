package com.example.foodcookbook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 class RecipeBook(
    var idRecipebook:String,
    var nameRecipebook: String = "",
    var productPhoto: String = "",
    var author: String = "",
    var recipeBook: String = "",
    var created_at: String = ""
): Parcelable{
}