package com.example.mvi_app

import arrow.core.Either
import com.example.mvi_app.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject

sealed class Error {
    object UserNotFound : Error()
    object NetworkError : Error()
}

class Repository @Inject constructor() {
    suspend fun getUser(user_id: Int): Either<Error, User> {
        delay(1000L)
        when (user_id) {
            1 -> return Either.Right(User(1, "jean", 22))
            else -> return Either.Left(Error.UserNotFound)
        }
    }
}


