package com.example.solutionx.features.login.domain.useCases

import android.util.Log
import android.widget.Toast
import com.example.solutionx.common.data.models.Resource
import com.example.solutionx.common.data.models.exception.ExceptionHelper
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LoginWithPhoneUC(private val loginRepository: ILoginRepository) {

    suspend operator fun invoke(userDto: UserDto): Flow<Resource<User?>> =
        flow {
            emit(Resource.Loading(true))
            val localUser = loginRepository.getUser()
            if (localUser != null) {
                emit(Resource.Success(localUser))
                emit(Resource.Loading(false))
            } else {
                val data = loginRepository.loginWithPhone(userDto)
                if (data != null) {
                    if (data.error == null) {
                        loginRepository.saveUser(data)
                        emit(Resource.Success(localUser))
                        emit(Resource.Loading(false))
                    } else {
                        emit(ExceptionHelper.generalExceptionHandler(Exception(data.error)))
                        emit(Resource.Loading(false))
                    }
                }
            }
        }
}