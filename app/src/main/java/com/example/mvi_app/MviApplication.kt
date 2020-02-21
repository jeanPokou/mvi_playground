package com.example.mvi_app

import android.app.Application
import android.util.Log
import com.example.mvi_app.di.ApplicationComponent
import com.example.mvi_app.di.DaggerApplicationComponent

class MviApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("JMP", "Application starting")
    }
}