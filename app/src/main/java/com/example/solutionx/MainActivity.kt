@file:Suppress("DEPRECATION")

package com.example.solutionx

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.solutionx.databinding.ActivityMainBinding
import com.example.solutionx.databinding.FragmentLoginWithEmailBinding
import com.example.solutionx.features.login.presenter.activities.LoginWithEmailFragment
import com.example.solutionx.features.login.presenter.activities.LoginWithPhoneFragment
import com.example.solutionx.features.login.presenter.activities.LoginWithSocialFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragments.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        })

    }


}

