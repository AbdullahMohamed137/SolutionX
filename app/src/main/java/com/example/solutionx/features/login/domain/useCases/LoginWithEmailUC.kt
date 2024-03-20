package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.common.Resource
import com.example.solutionx.features.login.common.exception.ExceptionHelper
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginWithEmailUC @Inject constructor(private val loginRepository: ILoginRepository) {
//    suspend operator fun invoke(email: String, password: String) =
//        loginRepository.loginWithEmail(email, password)

    operator fun invoke(email: String, password: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading)
        try {
            val data = loginRepository.loginWithEmail(email, password)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(ExceptionHelper.generalExceptionHandler(e))
        }
    }


}