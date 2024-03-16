package com.example.solutionx.features.login.data.localDS

import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.data.response.UserResponse

interface ILoginLocalDS {
    fun saveUser(userEntity: UserEntity)

    fun getUser() : UserEntity
}