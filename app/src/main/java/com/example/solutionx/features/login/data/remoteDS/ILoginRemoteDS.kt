package com.example.solutionx.features.login.data.remoteDS

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.data.response.UserResponse

interface ILoginRemoteDS {

     //retrofit
     fun login() : UserDto

     fun saveUser(userEntity: UserEntity)

}