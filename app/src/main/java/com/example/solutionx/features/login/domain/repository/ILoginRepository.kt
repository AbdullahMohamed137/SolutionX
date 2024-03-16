package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.domain.models.User

interface ILoginRepository {
    suspend fun getUserFromLocalDS(): User
    suspend fun setUserToLocalDS(user: User)

    suspend fun loginWithEmail(email: String, password: String): UserDto
    suspend fun loginWithPhone(phoneNumber: Int): UserDto
    suspend fun loginWithSocial(email: String, password: String): UserDto
}