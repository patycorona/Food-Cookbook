package com.example.foodcookbook.platform.di.component

import com.example.foodcookbook.platform.di.module.RegisterModule
import com.example.foodcookbook.platform.di.module.RepositoryModule
import com.example.foodcookbook.platform.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RegisterModule:: class,
        RetrofitModule::class
    ]
)
interface MainComponent {
}