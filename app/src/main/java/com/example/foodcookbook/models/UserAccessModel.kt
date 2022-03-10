package com.example.foodcookbook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserAccessModel(
    var userid:String,
    var email: String = "",
    var password: String = ""
    ): Parcelable {}