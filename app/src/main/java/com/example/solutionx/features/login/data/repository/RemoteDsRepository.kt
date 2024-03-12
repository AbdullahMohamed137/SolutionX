package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.data.remoteDS.LoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRemoteRepo

class RemoteDsRepository : ILoginRemoteRepo{
    var loginRemoteDs = LoginRemoteDS()


    fun mapDtoToDomain(userDto: UserDto) : User {
        return User(userDto.id, userDto.name, userDto.email)
    }


}