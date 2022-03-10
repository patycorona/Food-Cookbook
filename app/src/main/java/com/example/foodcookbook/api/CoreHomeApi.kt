package com.example.foodcookbook.api

import com.example.foodcookbook.models.ManyRecipeBookResponse
import com.example.foodcookbook.models.UserAccessRequest
import com.example.foodcookbook.models.UserAccessResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CoreHomeApi {

   @GET("/recipe")
   @Headers("Content-Type: application/json ")
    fun getRecipebook(): Single<ManyRecipeBookResponse>

    @POST("/access")
    @Headers("Content-Type: application/json ")
    fun userAccess( @Body userAccessRequest: UserAccessRequest): Single<UserAccessResponse>

}