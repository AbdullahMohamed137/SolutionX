package com.example.solutionx.features.login.domain.models.response

data class Phone(
    val country_code: String,
    val extension: Any? = null,
    val holder_name: Any? = null,
    val id: Int? = null,
    val number: String,
    val type: Any? = null
)