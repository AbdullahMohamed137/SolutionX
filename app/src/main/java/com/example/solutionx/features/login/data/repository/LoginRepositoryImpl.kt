package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.Mapper.mapDomainToEntity
import com.example.solutionx.features.login.data.mapper.Mapper.mapDtoToDomain
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginRemoteDS: ILoginRemoteDS) :
    ILoginRepository {
    override suspend fun getUserFromLocalDS(): User {
        val user = loginRemoteDS.login()
        return mapDtoToDomain(user)
    }

    override suspend fun setUserToLocalDS(user: User) {
        val userEntity = mapDomainToEntity(user)
        loginRemoteDS.saveUser(userEntity)
    }

    override suspend fun loginWithEmail(email: String, password: String): UserDto {
        return loginRemoteDS.login()
    }

    override suspend fun loginWithPhone(phoneNumber: Int): UserDto {
        return loginRemoteDS.login()
    }

    override suspend fun loginWithSocial(email: String, password: String): UserDto {
        return loginRemoteDS.login()
    }
}