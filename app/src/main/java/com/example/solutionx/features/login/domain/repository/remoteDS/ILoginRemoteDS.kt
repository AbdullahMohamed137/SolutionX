package com.example.solutionx.features.login.domain.repository.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity

internal interface ILoginRemoteDS {

    fun loginEmail(email: String, password: String): UserDto
    fun loginPhone(phoneNumber: String, password: String): UserDto
    fun loginSocial(email: String, password: String): UserDto

}