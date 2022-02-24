package com.example.foodcookbook.platform.di.module

import com.example.foodcookbook.api.CoreHomeApi
import com.example.foodcookbook.repository.RecipeBookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun productRepositoryProvider(apiService: CoreHomeApi):
            RecipeBookRepository = RecipeBookRepository(apiService)

}