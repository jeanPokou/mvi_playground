package com.example.mvi_app.di.module

import com.example.mvi_app.Repository
import com.example.mvi_app.domain.usecase.GetUser
import com.example.mvi_app.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GetUserModule {

    @Provides
    fun provideGetUser(repository: Repository): GetUser {
        return GetUser(repository)
    }

    @Provides
    fun provideViewModelFactory(getUser: GetUser):ViewModelFactory {
        return ViewModelFactory(getUser)
    }
}