package com.example.solutionx.features.login.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val accessToken: String,
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String
) : Parcelable
