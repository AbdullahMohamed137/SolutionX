package com.example.solutionx.features.login.common

import android.content.Context
import androidx.annotation.StringRes
import com.example.solutionx.features.login.domain.models.User

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()

    data class Success<out T>(val data: T) : Resource<T>()

    data class Failure(
        private val message: String? = null,
        @StringRes
        private val resString: Int? = null,
        val title: String? = null,
        val exception: Throwable? = null
    ) : Resource<Nothing>() {
        fun getMessage(context: Context): String =
            resString?.let { context.getString(resString) } ?: message ?: "unHandled exception"
    }
}