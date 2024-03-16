package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginWithEmailUC @Inject constructor(private val loginRepository: ILoginRepository) {
    suspend operator fun invoke(email: String, password: String) =
        loginRepository.loginWithEmail(email, password)

}