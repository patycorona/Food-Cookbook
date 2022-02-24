package com.example.foodcookbook.api

import com.example.foodcookbook.models.ManyRecipeBookResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoreHomeApi {

   @GET("/product")
   @Headers("Content-Type: application/json ")
    fun getProduct( ): Single<ManyRecipeBookResponse>
}