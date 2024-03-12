package com.example.solutionx.features.login.presenter.viewModel

import androidx.lifecycle.ViewModel
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC

class LoginWithEmailViewModel : ViewModel() {
     var loginWithEmailUC = LoginWithEmailUC()
}