package com.example.mvi_app.di

import android.content.Context
import com.example.mvi_app.MainActivity
import com.example.mvi_app.di.module.GetUserModule
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.InternalCoroutinesApi

@Component(
    modules = [
        GetUserModule::class
    ]
)
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
    @InternalCoroutinesApi
    fun satisfyDependenciesFor(mainActivity: MainActivity)
}
