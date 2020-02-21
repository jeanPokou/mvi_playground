package com.example.mvi_app.domain.usecase

import com.example.mvi_app.Repository
import com.example.mvi_app.domain.UseCase
import com.example.mvi_app.model.User
import javax.inject.Inject


// class for getting user
// need a repository class
//A way to get argument passed to class and forward to repository
// domain model should handle error and success cases
// use case has a single responsability so we can use invoke

/*class GetUser @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(user_id: Int): Either<Error, User> {
        return withContext(context = Dispatchers.IO) {
            repository.getUser(user_id)
        }
    }
}*/
class GetUser @Inject constructor(private val repository: Repository) : UseCase<User, Int>() {
    override suspend fun run(params: Int) = repository.getUser(params)
}




