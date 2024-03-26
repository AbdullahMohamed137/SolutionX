package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.domain.models.User

internal interface ILoginRepository {
    //fun loginWithEmail(email: String, password: String): User
    suspend fun loginWithPhone(userDto: UserDto): User?

    //fun loginWithSocial(email: String, password: String): User
    suspend fun saveUser(user: User)

    suspend fun getUser(): User

}