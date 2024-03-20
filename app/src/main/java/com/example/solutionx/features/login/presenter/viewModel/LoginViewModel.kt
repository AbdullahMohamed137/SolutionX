package com.example.solutionx.features.login.presenter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.features.login.common.Resource
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val getUserWithEmail: LoginWithEmailUC,
    val getUserWithPhone: LoginWithPhoneUC,
    val getUserWithSocial: LoginWithSocialUC,
) : ViewModel() {

    private val _users: MutableStateFlow<User?> = MutableStateFlow(null)
    val users: StateFlow<User?> = _users
    fun getUserEmail(email: String, password: String) =
        viewModelScope.launch {
            getUserWithEmail.invoke(email, password).collect {
                when (it) {
                    is Resource.Failure -> {}
                    is Resource.Success -> {}
                    else -> {}
                }
            }

        }

    fun getUserPhone(phoneNumber: Int, password: String) {
        viewModelScope.launch {
            getUserWithPhone.invoke(phoneNumber, password).collect {
                when (it) {
                    is Resource.Failure -> {}
                    is Resource.Success -> {}
                    else -> {}
                }
            }
        }
    }

    fun getUserSocial(email: String, password: String) {
        viewModelScope.launch {
            getUserWithSocial.invoke(email, password).collect {
                when (it) {
                    is Resource.Failure -> {}
                    is Resource.Success -> {}
                    else -> {}
                }
            }
        }
    }
}

