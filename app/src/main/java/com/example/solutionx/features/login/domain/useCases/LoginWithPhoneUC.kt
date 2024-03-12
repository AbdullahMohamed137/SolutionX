package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.data.repository.LocalDsRepository
import com.example.solutionx.features.login.data.repository.RemoteDsRepository

class LoginWithPhoneUC {
    var localDsRepository = LocalDsRepository()
    var remoteDsRepository = RemoteDsRepository()
    fun call(phoneNumber : Int) {}
}