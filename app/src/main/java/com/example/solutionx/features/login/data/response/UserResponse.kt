package com.example.solutionx.features.login.data.response

import com.example.solutionx.features.login.domain.models.User

data class UserResponse(
    val accessToken: String,
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: Int
)
