package com.example.foodcookbook.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcookbook.models.*
import com.example.foodcookbook.repository.RecipeBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RecipeBookViewModel @Inject constructor(
    var recipeBookRepository: RecipeBookRepository
): ViewModel() {

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val listRecipeBooks : MutableLiveData<RecipeBookResult> by lazy {
        MutableLiveData<RecipeBookResult>()
    }

    val userAccessResult : MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    fun getRecipebook(){

        compositeDisposable += recipeBookRepository.getRecipebooks()
            .subscribeOn(Schedulers.io())
            .subscribe({listRecipeBook ->
                listRecipeBooks.postValue(
                    RecipeBookResult(
                        sussess = true,
                        list = listRecipeBook
                    )
                )

            },{
                listRecipeBooks.postValue(
                    RecipeBookResult(
                        sussess = false
                    )
                )
            })
    }

    fun userValidation(email:String,pwd:String,userId:String) {

        compositeDisposable += recipeBookRepository.userAccess(
            user = email, password = pwd, userId = userId)
            .subscribeOn(Schedulers.io())
            .subscribe({ accessResultModel ->
                userAccessResult.postValue(accessResultModel)
            }, {
                userAccessResult.postValue(AccessResultModel(
                    code = "-1",
                    message = "an exception occurred"
                ))
            })
    }

    override fun onCleared()
    {
        compositeDisposable.clear()
        super.onCleared()
    }

}