package com.example.solutionx.features.login.domain.repository.localDS

import com.example.solutionx.features.login.data.models.UserEntity

internal interface ILoginLocalDS {
    fun saveUser(userEntity: UserEntity)
}