package com.example.mvi_app.domain

import arrow.core.Either
import com.example.mvi_app.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out Type, in Params> {
    abstract suspend fun run(params: Params): Either<Error, Type>
    suspend operator fun invoke(params: Params): Either<Error, Type> {
        return withContext(Dispatchers.IO) {
            run(params)
        }
    }
}

