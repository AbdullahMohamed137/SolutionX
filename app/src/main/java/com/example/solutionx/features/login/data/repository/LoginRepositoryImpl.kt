package com.example.solutionx.features.login.data.repository

import android.util.Log
import com.example.solutionx.common.data.mapper.Mapper.mapDomainToEntity
import com.example.solutionx.common.data.mapper.Mapper.mapDtoToDomain
import com.example.solutionx.common.data.mapper.Mapper.mapEntityToDomain
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.common.domain.repository.remoteDS.ILoginRemoteDS
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import com.example.solutionx.common.domain.repository.localDS.ILoginLocalDS

internal class LoginRepositoryImpl(
    private val remoteDS: ILoginRemoteDS,
    private val localDS: ILoginLocalDS
) : ILoginRepository {


//    override fun loginWithEmail(email: String, password: String): User {
//        val result = remoteDS.loginEmail(email, password)
//        return mapDtoToDomain(result)
//    }


    override suspend fun loginWithPhone(userDto: UserDto): User? {
        var user: User? = null
        return try {
            val userResponse = remoteDS.loginPhone(userDto)
            if (userResponse.isSuccessful) {
                val response = userResponse.body()
                if (response != null) {
                    user = mapDtoToDomain(response)
                }
            } else {
                user = User(error = userResponse.message())
            }
            user
        } catch (e: Exception) {
            user = User(error = e.localizedMessage)
            user
        }
    }

//    override fun loginWithSocial(email: String, password: String): User {
//        val result = remoteDS.loginSocial(email, password)
//        return mapDtoToDomain(result)
//     }

    override suspend fun saveUser(user: User) {
        val result = mapDomainToEntity(user)
        localDS.saveUser(result)
    }

    override suspend fun getUser(): User {
        val user = localDS.getUser()
        return mapEntityToDomain(user)
    }
}