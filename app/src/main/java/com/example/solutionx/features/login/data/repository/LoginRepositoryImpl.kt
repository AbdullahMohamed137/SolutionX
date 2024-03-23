package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.Mapper.mapDomainToEntity
import com.example.solutionx.features.login.data.mapper.Mapper.mapDtoToDomain
import com.example.solutionx.features.login.domain.repository.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import com.example.solutionx.features.login.domain.repository.localDS.ILoginLocalDS

internal class LoginRepositoryImpl(
    private val remoteDS: ILoginRemoteDS,
    private val localDS: ILoginLocalDS
) : ILoginRepository {
    override fun loginWithEmail(email: String, password: String): User {
        val result = remoteDS.loginEmail(email, password)
        return mapDtoToDomain(result)
    }

    override fun loginWithPhone(phoneNumber: String, password: String): User {
        val result = remoteDS.loginPhone(phoneNumber, password)
        return mapDtoToDomain(result)
    }

    override fun loginWithSocial(email: String, password: String): User {
        val result = remoteDS.loginSocial(email, password)
        return mapDtoToDomain(result)
    }

    override fun saveUser(user: User) {
        val result = mapDomainToEntity(user)
        localDS.saveUser(result)
    }
}