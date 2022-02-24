package com.example.foodcookbook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RecipeBookModel(
    var idRecipebook:Int,
    var nameRecipebook: String = "",
    var productPhoto: Int,
    var author: String = "",
    var recipeBook: String = ""
): Parcelable {}