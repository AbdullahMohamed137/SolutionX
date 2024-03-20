package com.example.solutionx.features.login.data.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity

interface ILoginRemoteDS {

     suspend fun loginEmail(email: String, password: String) : UserDto
     fun loginPhone(phoneNumber: Int, password: String) : UserDto

     fun saveUser(userEntity: UserEntity)

}