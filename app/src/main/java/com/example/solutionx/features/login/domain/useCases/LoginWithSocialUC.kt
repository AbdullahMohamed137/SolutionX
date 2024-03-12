package com.example.solutionx.features.login.domain.useCases

import com.example.solutionx.features.login.data.repository.LocalDsRepository
import com.example.solutionx.features.login.data.repository.RemoteDsRepository

class LoginWithSocialUC {
    var localDsRepository = LocalDsRepository()
    var remoteDsRepository = RemoteDsRepository()
    fun callFacebook(facebookLogin : String){}
    fun callGoogle(googleLogin : String){}
}