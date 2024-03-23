package com.example.solutionx.features.login.presenter.activities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.solutionx.databinding.FragmentLoginWithPhoneBinding
import com.example.solutionx.features.login.presenter.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginWithPhoneFragment : Fragment() {
    private lateinit var binding: FragmentLoginWithPhoneBinding
    private val vm: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginWithPhoneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getUserPhone("0111110", "12345")
        lifecycleScope.launch {
            vm.users.collect {
                it?.let {
                    binding.txtName.text = it.name
                    binding.txtPhone.text = it.phoneNumber
                }
            }
        }
    }
}