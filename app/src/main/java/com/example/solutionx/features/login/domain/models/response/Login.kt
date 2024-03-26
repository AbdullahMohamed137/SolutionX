package com.example.solutionx.features.login.domain.models.response

data class Login(
    val message: String,
    val token: String,
    val user: User?
)