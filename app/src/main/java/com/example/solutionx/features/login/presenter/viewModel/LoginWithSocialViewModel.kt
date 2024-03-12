package com.example.solutionx.features.login.presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC

class LoginWithSocialViewModel : ViewModel() {
     var loginWithSocialUC = LoginWithSocialUC()
}