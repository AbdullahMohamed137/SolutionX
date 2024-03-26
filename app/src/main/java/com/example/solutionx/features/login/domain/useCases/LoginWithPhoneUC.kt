package com.example.solutionx.features.login.domain.useCases

import android.util.Log
import com.example.solutionx.common.data.models.Resource
import com.example.solutionx.common.data.models.exception.ExceptionHelper
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LoginWithPhoneUC(private val loginRepository: ILoginRepository) {
//    suspend operator fun invoke(phoneNumber: Int, password: String) =
//        loginRepository.loginWithPhone(phoneNumber, password)

    suspend operator fun invoke(userDto: UserDto): Flow<Resource<User?>> =
        flow {
            emit(Resource.Loading(true))
            val data = loginRepository.loginWithPhone(userDto)
//            if (data != null) {
//                loginRepository.saveUser(data)
//                data = loginRepository.getUser()
//                Log.e("asfasgasgasgasfasf", data.toString())
//            }
            if (data?.error == null) {
                emit(Resource.Success(data))
                emit(Resource.Loading(false))
            } else {
                emit(ExceptionHelper.generalExceptionHandler(Exception(data.error)))
                emit(Resource.Loading(false))
            }
        }

    suspend fun saveUserToLocalDS(user: User) {
        loginRepository.saveUser(user)
    }

    suspend fun getUserFromLocalDS(): User = loginRepository.getUser()
}