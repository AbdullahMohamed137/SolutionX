package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.domain.models.User

interface ILoginRepository {
    suspend fun loginWithEmail(email: String, password: String): User
    suspend fun loginWithPhone(phoneNumber: Int, password: String): User
    suspend fun loginWithSocial(email: String, password: String): User
}