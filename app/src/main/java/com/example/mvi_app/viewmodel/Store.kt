package com.example.mvi_app.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvi_app.model.ViewState
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Store(private val initialState: _ViewState.Idle) : CoroutineScope {

    val job = Job()

    fun cancel() = job.cancel()

    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    val stateLiveData = MutableLiveData<_ViewState>()
        .apply {
            value = initialState
        }
    fun state() = stateLiveData.value!!

//    fun dispatchState( f: suspend  (_ViewState) -> State<_ViewState>) = launch {
//        val reducer = f(state())
//        withContext(Dispatchers.Main) {
//            dispatchState(reducer(state()))
//        }
//    }




}

class State<T> {

}

