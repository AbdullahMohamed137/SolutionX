package com.example.solutionx.common

import com.example.solutionx.common.exception.SolutionXException

sealed class Resource<out Model> {
    data class Loading(val loading: Boolean) : Resource<Nothing>()

    data class Success<out Model>(val data: Model) : Resource<Model>()

    data class Failure(
        val exception: SolutionXException,
        private val message: String? = null
    ) : Resource<Nothing>()
}