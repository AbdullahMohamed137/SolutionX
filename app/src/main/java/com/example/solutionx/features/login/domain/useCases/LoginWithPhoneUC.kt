package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.common.Resource
import com.example.solutionx.common.exception.ExceptionHelper
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginWithPhoneUC @Inject constructor(private val loginRepository: ILoginRepository) {
//    suspend operator fun invoke(phoneNumber: Int, password: String) =
//        loginRepository.loginWithPhone(phoneNumber, password)

    operator fun invoke(phoneNumber: String, password: String): Flow<Resource<User>> =
        flow {
            emit(Resource.Loading(true))
            val data = loginRepository.loginWithPhone(phoneNumber, password)
            try {
                emit(Resource.Success(data))
                emit(Resource.Loading(false))
            } catch (e: Exception) {
                emit(ExceptionHelper.generalExceptionHandler(e))
                emit(Resource.Loading(false))
            }
        }

}