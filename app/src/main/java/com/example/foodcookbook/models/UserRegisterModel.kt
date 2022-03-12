package com.example.foodcookbook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserRegisterModel(
    var firstName:String = "",
    var lastName:String = "",
    var email:String = "",
    var password:String = "",
    var birthDate:String = ""

): Parcelable{}