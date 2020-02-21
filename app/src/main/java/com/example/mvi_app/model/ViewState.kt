package com.example.mvi_app.model

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
}
