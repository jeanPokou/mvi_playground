package com.example.mvi_app.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mvi_app.model.ViewState

abstract class MainViewModel : ViewModel() {

    lateinit var store: Store


    abstract fun interpret(action: ViewAction)


    override fun onCleared() {
        store.cancel()
        super.onCleared()
    }
}

class ViewAction {

}
