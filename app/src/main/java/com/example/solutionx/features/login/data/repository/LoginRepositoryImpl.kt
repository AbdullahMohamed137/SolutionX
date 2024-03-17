package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.data.mapper.Mapper.mapDomainToEntity
import com.example.solutionx.features.login.data.mapper.Mapper.mapDtoToDomain
import com.example.solutionx.features.login.data.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginRemoteDS: ILoginRemoteDS) :
    ILoginRepository {


    override suspend fun loginWithEmail(email: String, password: String): User {
        val user = loginRemoteDS.loginEmail(email, password)
        return mapDtoToDomain(user)
    }

    override suspend fun loginWithPhone(phoneNumber: Int, password: String): User {
        val user = loginRemoteDS.loginPhone(phoneNumber, password)
        return mapDtoToDomain(user)
    }

    override suspend fun loginWithSocial(email: String, password: String): User {
        val user = loginRemoteDS.loginEmail(email, password)
        return mapDtoToDomain(user)
    }
}