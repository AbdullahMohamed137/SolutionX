package com.example.solutionx.features.login.presenter.activities

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.solutionx.common.data.repository.localDS.KEY_NAME
import com.example.solutionx.common.data.repository.localDS.KEY_PHONE
import com.example.solutionx.common.data.repository.localDS.dataStore
import com.example.solutionx.databinding.FragmentLoginWithPhoneBinding
import com.example.solutionx.features.login.domain.models.response.Phone
import com.example.solutionx.features.login.data.models.UserDto
import com.example.solutionx.features.login.presenter.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
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



        val phone = Phone("0020", number = "100100100")
        val user = UserDto(phone = phone, password = "123456789")

        vm.getUserPhone(user)
        lifecycleScope.launch {
            vm.users.collect {
                it?.let {
                    vm.saveUserFromLocalDS(it)
                    val savedUser = vm.getUserFromLocalDS()
                    if (it.error == null){
                         binding.txtName.text = it.name
                        binding.txtPhone.text = it.phoneNumber
                        //Log.e("pjionibbjhyubijbyuijkihnjk", "${vm.getUserFromLocalDS().name}")

                        Toast.makeText(context, "Login is done successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        binding.txtName.text = vm.getUserFromLocalDS().name
                        binding.txtPhone.text = vm.getUserFromLocalDS().phoneNumber
                       // Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
}