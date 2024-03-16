package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.data.repository.LoginRepositoryImpl
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginWithPhoneUC @Inject constructor(private val loginRepository: ILoginRepository) {
    suspend operator fun invoke(phoneNumber: Int) = loginRepository.loginWithPhone(phoneNumber)

}