package com.example.solutionx.features.login.presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC

class LoginWithPhoneViewModel : ViewModel() {
     var loginWithPhoneUC = LoginWithPhoneUC()
}