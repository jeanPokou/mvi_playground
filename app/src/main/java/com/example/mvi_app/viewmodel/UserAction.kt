package com.example.mvi_app.viewmodel

sealed class UserAction {
    data class findUserById(val user_id: Int) : UserAction()
}


// Reducer takes a list of actions and for every action return a state

class Reducer (
    private  val actions: List<ViewAction>
)




