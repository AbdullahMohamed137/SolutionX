package com.example.solutionx.features.login.data.models

import com.google.gson.annotations.SerializedName

internal data class UserDto(
    @SerializedName("access_token") val accessToken: String? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone_number") val phoneNumber: String? = null
)
