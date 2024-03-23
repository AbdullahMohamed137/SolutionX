package com.example.solutionx.features.login.data.repository.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.domain.repository.remoteDS.ILoginRemoteDS

internal class LoginRemoteDsImpl : ILoginRemoteDS {

    override fun loginEmail(email: String, password: String): UserDto {
        val body = hashMapOf(
            "email" to email,
            "password" to password
        )
        return UserDto("",0,"User",body["email"],"")
    }

    override fun loginPhone(phoneNumber: String, password: String): UserDto {
        val body = hashMapOf(
            "phone_number" to phoneNumber,
            "password" to password
        )
        return UserDto("",0, "User", "", body["phone_number"])
    }

    override fun loginSocial(email: String, password: String): UserDto {
        val body = hashMapOf(
            "email" to email,
            "password" to password
        )
        return UserDto("",0,"User",body["email"],"")
    }
}