package com.example.solutionx.common.data.models.exception

import androidx.annotation.StringRes
import com.example.solutionx.R

sealed class SolutionXException(exceptionMessage: String?) :
    Exception(exceptionMessage) {

    sealed class Network(message: String? = null) : SolutionXException(message) {
        data class Retrial(@StringRes val messageRes: Int, override val message: String?) :
            Network(message)

        data class Unhandled(@StringRes val messageRes: Int, override val message: String?) :
            Network(message)
    }

    sealed class Client(message: String? = null) : SolutionXException(message) {
        data object Unauthorized : Client(message = "Unauthorized Access.")

//        data class ResponseValidation(
//            val errors: Map<String, String> = hashMapOf(), override val message: String?
//        ) : SolutionXException(message)

        data class Unhandled(val httpErrorCode: Int, override val message: String?) : Client(
            message = "Unhandled client error with code:${httpErrorCode}, and the failure reason: $message"
        )
    }

    sealed class Server(message: String? = null) : SolutionXException(message) {
        data class InternalServerError(val httpErrorCode: Int, override val message: String?) :
            Server(message = "Internal server error with code:${httpErrorCode}, and the failure reason: $message")
    }

    sealed class Local(exceptionMessage: String? = null) : SolutionXException(exceptionMessage) {
        data class RequestValidation(override val message: String? = null) :
            Local(exceptionMessage = R.string.empty_password.toString())

        data class IOOperation(@StringRes val messageRes: Int, override val message: String? = "") :
            Local(message)
    }

    data class Unknown(override val message: String?) : SolutionXException(message)
}