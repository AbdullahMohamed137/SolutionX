package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.common.Resource
import com.example.solutionx.features.login.common.exception.ExceptionHelper
import com.example.solutionx.features.login.common.exception.SolutionXException
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginWithPhoneUC @Inject constructor(private val loginRepository: ILoginRepository) {
//    suspend operator fun invoke(phoneNumber: Int, password: String) =
//        loginRepository.loginWithPhone(phoneNumber, password)

    suspend operator fun invoke(phoneNumber: Int, password: String): Flow<Resource<User>> =
        flow {
            emit(Resource.Loading)
            try {
                val data = loginRepository.loginWithPhone(phoneNumber, password)
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(ExceptionHelper.generalExceptionHandler(e))
            }
        }

}