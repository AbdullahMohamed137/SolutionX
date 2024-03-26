package com.example.solutionx.features.login.data.models

import com.example.solutionx.features.login.domain.models.response.Phone
import com.google.gson.annotations.SerializedName

internal data class UserDto(
    @SerializedName("access_token") val accessToken: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("email") val email: String? = null,
    val phone: Phone,
    val password: String
)
