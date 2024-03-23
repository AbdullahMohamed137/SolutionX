package com.example.solutionx.features.login.data.models

internal data class UserEntity(
    val accessToken: String,
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String
)
