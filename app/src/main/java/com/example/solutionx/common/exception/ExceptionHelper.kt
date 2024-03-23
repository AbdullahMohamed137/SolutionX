package com.example.solutionx.common.exception

import com.example.solutionx.common.Resource

object ExceptionHelper {
    fun generalExceptionHandler(e: Throwable): Resource.Failure {
        return if (e is SolutionXException)
            when (e) {
                is SolutionXException.Local.RequestValidation -> {
                    Resource.Failure(exception = e)
                }
                else ->
                    Resource.Failure(exception = e, "something wrong happened")
            }
        else
            Resource.Failure(
                exception = e as SolutionXException, "un handled exception, please try again later."
            )
    }
}