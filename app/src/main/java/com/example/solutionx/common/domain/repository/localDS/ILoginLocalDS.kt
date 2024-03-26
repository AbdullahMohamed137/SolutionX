package com.example.solutionx.common.domain.repository.localDS

import com.example.solutionx.features.login.data.models.UserEntity


internal interface ILoginLocalDS {
    suspend fun saveUser(userEntity: UserEntity)

     suspend fun getUser(): UserEntity
}