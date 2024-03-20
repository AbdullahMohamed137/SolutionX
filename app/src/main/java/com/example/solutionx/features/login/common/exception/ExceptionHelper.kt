package com.example.solutionx.features.login.common.exception

import com.example.solutionx.R
import com.example.solutionx.features.login.common.Resource

object ExceptionHelper {
    fun generalExceptionHandler(e: Throwable): Resource.Failure {
        return if (e is SolutionXException)
            when (e) {
                is EmptyPasswordException ->
                    Resource.Failure(resString = R.string.empty_password, exception = e)

                else ->
                    Resource.Failure(message = "something wrong happened", exception = e)
            }
        else
            Resource.Failure(
                "un handled exception, please try again later.",
                exception = e
            )
    }
}