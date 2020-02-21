package com.example.mvi_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.mvi_app.Error
import com.example.mvi_app.domain.usecase.GetUser
import com.example.mvi_app.model.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class UserViewModel @Inject constructor(private val getUser: GetUser) : ViewModel() {

    private val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }


//    val bindToState  = flow{
//        for (it in 1.. 2) {
//            emit(it)
//        }
//    }

    private val bindToState = ConflatedBroadcastChannel<Either<Error, User>>()
    fun getState() = bindToState.asFlow()


    fun handleAction(action: UserAction) = when (action) {
        is UserAction.findUserById -> fetchUser(action.user_id)
    }

    fun getUser(): LiveData<User> {
        fetchUser(1)
        return user
    }

    private fun fetchUser(user_id: Int) = viewModelScope.launch {
        bindToState.send(getUser(user_id))
    }


}




