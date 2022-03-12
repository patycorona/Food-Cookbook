package com.example.foodcookbook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodcookbook.models.AccessResultModel
import com.example.foodcookbook.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel  @Inject constructor
    ( var registerRepository: RegisterRepository) : ViewModel(){

    // ayuda a liberar los recursos cuando utilizamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userRegisterLD : MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    fun UserRegister(firstName:String, lastName:String, email:String, password:String, birthDate:String)
    {
        compositeDisposable += registerRepository.UserRegister(
            firstName = firstName, lastName = lastName, email = email,
            password = password, birthDate = birthDate)
            .subscribeOn(Schedulers.io())
            .subscribe({ userRegister ->
                userRegisterLD.postValue(userRegister)
            }, {
                    userRegisterLD.postValue(AccessResultModel(
                        code = "-1",
                        message = "an exception occurred, please try again"
                    ))
                }
            )

    }

    override fun onCleared()
    {
        compositeDisposable.clear()
        super.onCleared()
    }


}