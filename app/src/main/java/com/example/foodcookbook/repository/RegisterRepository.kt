package com.example.foodcookbook.repository

import com.example.foodcookbook.api.CoreHomeApi
import com.example.foodcookbook.mapping.toModel
import com.example.foodcookbook.models.AccessResultModel
import com.example.foodcookbook.models.UserRegisterRequest
import io.reactivex.Single
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private  val apiService : CoreHomeApi
){
    fun UserRegister(firstName:String, lastName:String, email:String, password:String, birthDate:String)
    : Single<AccessResultModel> {
        return apiService.userRegister(
            userRegisterRequest = UserRegisterRequest(
                firstName = firstName,
                lastName = lastName,
                email = email,
                password = password,
                birthDate = birthDate
            )
        )
            .map { userAccessResponse ->
                userAccessResponse.toModel()
            }
    }

}