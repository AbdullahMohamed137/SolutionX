package com.example.solutionx.common.data.models.exception

import com.example.solutionx.common.data.models.Resource

object ExceptionHelper {
    fun generalExceptionHandler(e: Exception): Resource.Failure {
        return if (e is SolutionXException)
            when (e) {
                is SolutionXException.Local.RequestValidation -> {
                    Resource.Failure(exception = e)
                }
                else ->
                    Resource.Failure(exception = e, "something wrong happened")
            }
        else
            Resource.Failure(SolutionXException.Unknown("un handled exception, please try again later."))
    }
}