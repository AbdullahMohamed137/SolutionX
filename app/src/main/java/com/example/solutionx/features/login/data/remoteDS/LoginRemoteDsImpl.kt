package com.example.solutionx.features.login.data.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import javax.inject.Inject

class LoginRemoteDsImpl @Inject constructor() : ILoginRemoteDS {

    override fun loginEmail(email: String, password: String): UserDto {
        TODO("Not yet implemented")
    }

    override fun loginPhone(phoneNumber: Int, password: String): UserDto {
        TODO("Not yet implemented")
    }

    override fun saveUser(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }
}