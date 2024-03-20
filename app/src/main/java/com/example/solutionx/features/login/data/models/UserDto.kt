package com.example.solutionx.features.login.data.models

data class UserDto(
    val accessToken: String,
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String
)
