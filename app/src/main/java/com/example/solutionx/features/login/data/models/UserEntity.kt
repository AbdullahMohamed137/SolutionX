package com.example.solutionx.features.login.data.models

internal data class UserEntity(
    val accessToken: String,
    val id: String,
    val name: String,
    val email: String,
    val phoneNumber: String
)
