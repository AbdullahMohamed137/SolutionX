package com.example.solutionx.features.login.domain.repository

import com.example.solutionx.features.login.domain.models.User

interface ILoginRepository {
    fun loginWithEmail(email: String, password: String): User
    fun loginWithPhone(phoneNumber: String, password: String): User
    fun loginWithSocial(email: String, password: String): User
    fun saveUser(user: User)

}