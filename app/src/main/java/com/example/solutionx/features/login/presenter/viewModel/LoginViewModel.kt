package com.example.solutionx.features.login.presenter.viewModel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.common.Resource
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
    private val userWithEmailUC: LoginWithEmailUC,
    private val userWithPhoneUC: LoginWithPhoneUC,
    private val userWithSocialUC: LoginWithSocialUC,
) : ViewModel() {

    private val _users: MutableStateFlow<User?> = MutableStateFlow(null)
    val users: StateFlow<User?> = _users
    fun getUserWithEmail(email: String, password: String) {
        viewModelScope.launch {
            userWithEmailUC.invoke(email, password).collect {
                when (it) {
                    is Resource.Failure -> {
                        it.exception
                    }

                    is Resource.Success -> {
                        val user = it.data
                        _users.value = user
                    }

                    is Resource.Loading -> {
                        it.loading
                    }
                }
            }
        }
    }

    fun getUserPhone(phoneNumber: String, password: String) {
        viewModelScope.launch {
            userWithPhoneUC.invoke(phoneNumber, password).collect {
                when (it) {
                    is Resource.Failure -> {
                        it.exception
                    }
                    is Resource.Success -> {
                        val user = it.data
                        _users.value = user
                    }
                    is Resource.Loading -> {
                        it.loading
                    }
                }
            }
        }
    }

    fun getUserSocial(email: String, password: String) {
        viewModelScope.launch {
            userWithSocialUC.invoke(email, password).collect {
                when (it) {
                    is Resource.Failure -> {
                        it.exception
                    }
                    is Resource.Success -> {
                        val user = it.data
                        _users.value = user
                    }
                    is Resource.Loading -> {
                        it.loading
                    }
                }
            }
        }
    }
}

