package com.example.solutionx.features.login.data.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRemoteDsImpl @Inject constructor() : ILoginRemoteDS {

    override suspend fun loginEmail(email: String, password: String): UserDto {
        delay(5000)
        return UserDto(
            "accessToken",
            4,
            "ahmed",
            "ali",
            "01097033133"
        )
    }

    override fun loginPhone(phoneNumber: Int, password: String): UserDto {
        TODO("Not yet implemented")
    }

    override fun saveUser(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }
}