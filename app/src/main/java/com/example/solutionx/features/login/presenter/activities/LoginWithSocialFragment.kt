package com.example.solutionx.features.login.presenter.activities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.solutionx.R
import com.example.solutionx.databinding.FragmentLoginWithSocialBinding
import com.example.solutionx.features.login.presenter.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginWithSocialFragment : Fragment() {
    private lateinit var binding: FragmentLoginWithSocialBinding
    private val vm : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginWithSocialBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getUserSocial("user@another.com", "12345")
        lifecycleScope.launch {
            vm.users.collect{
                it?.let {
                    binding.txtName.text = it.name
                    binding.txtEmail.text = it.email
                }
            }
        }
    }



}