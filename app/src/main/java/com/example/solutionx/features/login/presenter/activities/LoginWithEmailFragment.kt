package com.example.solutionx.features.login.presenter.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.example.solutionx.databinding.FragmentLoginWithEmailBinding
import com.example.solutionx.features.login.common.Resource
import com.example.solutionx.features.login.presenter.viewModel.LoginViewModel


class LoginWithEmailFragment : Fragment() {

    private val binding by lazy {
        FragmentLoginWithEmailBinding.inflate(layoutInflater)
    }

    private val vm by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getUserWithEmail("", "").asLiveData().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Failure -> Toast.makeText(
                    requireContext(),
                    it.getMessage(requireContext()),
                    Toast.LENGTH_SHORT
                ).show()

                Resource.Loading -> Toast.makeText(
                    requireContext(),
                    "loading",
                    Toast.LENGTH_SHORT
                ).show()

                is Resource.Success -> {
                    Toast.makeText(
                        requireContext(),
                        "Success" + it.data.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

}