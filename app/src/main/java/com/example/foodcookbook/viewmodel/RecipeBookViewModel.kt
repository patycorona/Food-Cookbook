package com.example.foodcookbook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcookbook.models.RecipeBookResult
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

    fun getRecipebook(){
        compositeDisposable += recipeBookRepository.getRecipebooks()
            .subscribeOn(Schedulers.io())
            .subscribe({listProduct ->
                listRecipeBooks.postValue(
                    RecipeBookResult(
                        sussess = true,
                        list = listProduct
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

    override fun onCleared()
    {
        compositeDisposable.clear()
        super.onCleared()
    }

}