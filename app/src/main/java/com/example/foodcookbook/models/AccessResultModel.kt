package com.example.foodcookbook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AccessResultModel (

    var code:String,
    var message: String = ""

) : Parcelable {}