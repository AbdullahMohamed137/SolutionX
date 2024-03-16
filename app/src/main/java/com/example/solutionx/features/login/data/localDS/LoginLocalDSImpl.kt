package com.example.solutionx.features.login.data.localDS

import com.example.solutionx.features.login.data.models.UserEntity
import javax.inject.Inject

class LoginLocalDSImpl @Inject constructor(): ILoginLocalDS {
    override fun saveUser(userEntity: UserEntity) {
        TODO("Not yet implemented")
    }

    override fun getUser(): UserEntity {
        TODO("Not yet implemented")
    }
}