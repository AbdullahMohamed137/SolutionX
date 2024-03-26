package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

internal class LoginWithEmailUC @Inject constructor(private val loginRepository: ILoginRepository) {

//    operator fun invoke(email: String, password: String): Flow<Resource<User>> =
//        flow {
//            emit(Resource.Loading(true))
//            val data = loginRepository.loginWithEmail(email, password)
//            try {
//                emit(Resource.Success(data))
//                emit(Resource.Loading(false))
//            } catch (e: Exception) {
//                emit(ExceptionHelper.generalExceptionHandler(e))
//                emit(Resource.Loading(false))
//            }
//        }
}