package com.example.solutionx.features.login.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var accessToken: String? = null,
    val id: String? = null,
    var name: String? = null,
    val email: String? = null,
    var phoneNumber: String? = null,
    var error: String? = null
) : Parcelable
