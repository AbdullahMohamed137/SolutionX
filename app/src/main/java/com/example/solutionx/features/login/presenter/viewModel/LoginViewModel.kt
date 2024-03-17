package com.example.solutionx.features.login.presenter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.features.login.domain.models.User
import com.example.solutionx.features.login.domain.useCases.LoginWithEmailUC
import com.example.solutionx.features.login.domain.useCases.LoginWithPhoneUC
import com.example.solutionx.features.login.domain.useCases.LoginWithSocialUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserWithEmail: LoginWithEmailUC,
    private val getUserWithPhone: LoginWithPhoneUC,
    private val getUserWithSocial: LoginWithSocialUC,
) : ViewModel() {

    private val _users: MutableStateFlow<User?> = MutableStateFlow(null)
    val users: StateFlow<User?> = _users

    fun getUserEmail(email: String, password: String) {
        viewModelScope.launch {
            try {
                _users.value = getUserWithEmail(email, password)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

    fun getUserPhone(phoneNumber: Int, password: String) {
        viewModelScope.launch {
            try {
                _users.value = getUserWithPhone(phoneNumber, password)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

    fun getUserSocial(email: String, password: String) {
        viewModelScope.launch {
            try {
                _users.value = getUserWithSocial(email, password)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

}