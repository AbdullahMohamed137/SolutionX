package com.example.solutionx.features.login.presenter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.data.models.UserEntity
import com.example.solutionx.features.login.data.response.UserResponse
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
    private val user: User
) : ViewModel() {

    private val _users: MutableStateFlow<UserDto?> = MutableStateFlow(null)
    val users: StateFlow<UserDto?> = _users

    fun getUserEmail() {
        viewModelScope.launch {
            try {
                _users.value = getUserWithEmail(user.email,user.password)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

    fun getUserPhone() {
        viewModelScope.launch {
            try {
                _users.value = getUserWithPhone(user.phoneNumber)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

    fun getUserSocial() {
        viewModelScope.launch {
            try {
                _users.value = getUserWithSocial(user.email, user.password)
            } catch (e: Exception) {
                Log.e("LoginViewModel", e.message.toString())
            }
        }
    }

}