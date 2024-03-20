package com.example.solutionx.features.login.data.localDS

import com.example.solutionx.features.login.data.models.UserEntity

interface ILoginLocalDS {
    fun saveUser(userEntity: UserEntity)

    fun getUser() : UserEntity
}