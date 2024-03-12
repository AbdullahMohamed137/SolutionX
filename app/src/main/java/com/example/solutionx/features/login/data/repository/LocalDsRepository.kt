package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.localDS.LoginLocalDS
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginLocalRepo
import org.modelmapper.ModelMapper

class LocalDsRepository : ILoginLocalRepo {
    var loginLocalDS = LoginLocalDS()

    fun mapEntityToDomain(userEntity: UserEntity) : User {
        val modelMapper = ModelMapper()
        return modelMapper.map(userEntity, User :: class.java)
    }

    fun mapDomainToEntity(user : User) : UserEntity {
        return UserEntity(user.id, user.name, user.email)
    }
}