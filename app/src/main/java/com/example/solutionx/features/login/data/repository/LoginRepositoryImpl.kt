package com.example.solutionx.features.login.data.repository

import com.example.solutionx.features.login.common.exception.EmptyPasswordException
import com.example.solutionx.features.login.common.exception.SolutionXException
import com.example.solutionx.features.login.data.mapper.Mapper.mapDtoToDomain
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginRemoteDS: ILoginRemoteDS) :
    ILoginRepository {
    private lateinit var user: UserDto

    override suspend fun loginWithEmail(email: String, password: String): User {
        if (password.isEmpty())
            throw EmptyPasswordException()
        try {
            user = loginRemoteDS.loginEmail(email, password)
        } catch (e: Exception) {
            throw SolutionXException(cause = e)
        }
        return mapDtoToDomain(user)
    }

    override suspend fun loginWithPhone(phoneNumber: Int, password: String): User {
        if (password.isEmpty())
            throw EmptyPasswordException()
        try {
            user = loginRemoteDS.loginPhone(phoneNumber, password)
        } catch (e: Exception) {
            throw SolutionXException(cause = e)
        }
        return mapDtoToDomain(user)
    }

    override suspend fun loginWithSocial(email: String, password: String): User {
        if (password.isEmpty())
            throw EmptyPasswordException()
        try {
            user = loginRemoteDS.loginEmail(email, password)
        } catch (e: Exception) {
            throw SolutionXException(cause = e)
        }
        return mapDtoToDomain(user)
    }
}