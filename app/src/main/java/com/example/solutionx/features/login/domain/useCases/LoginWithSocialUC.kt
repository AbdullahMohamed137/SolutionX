package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.common.Resource
import com.example.solutionx.common.exception.ExceptionHelper
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginWithSocialUC @Inject constructor(private val loginRepository: ILoginRepository) {
//    suspend operator fun invoke(email: String, password: String) =
//        loginRepository.loginWithSocial(email, password)

    operator fun invoke(email: String, password: String): Flow<Resource<User>> =
        flow {
            emit(Resource.Loading(true))
            try {
                val data = loginRepository.loginWithSocial(email, password)
                emit(Resource.Success(data))
                emit(Resource.Loading(false))
            } catch (e: Exception) {
                emit(ExceptionHelper.generalExceptionHandler(e))
                emit(Resource.Loading(false))
            }
        }

}