package com.example.solutionx.features.login.data.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.data.response.UserResponse
import javax.inject.Inject

class MockLoginRemoteDsImpl @Inject constructor() : ILoginRemoteDS {
    override fun login(): UserDto {
        TODO("Not yet implemented")
    }

    override fun saveUser(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }
}