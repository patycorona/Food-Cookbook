package com.example.foodcookbook.mapping

import com.example.foodcookbook.models.*

internal fun UserAccessResponse.toModel():AccessResultModel =
    AccessResultModel(code = result.code, message = result.message)



