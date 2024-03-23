package com.example.solutionx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.solutionx.databinding.ActivityFragmentBinding
import com.example.solutionx.features.login.presenter.activities.LoginWithEmailFragment
import com.example.solutionx.features.login.presenter.activities.LoginWithPhoneFragment
import com.example.solutionx.features.login.presenter.activities.LoginWithSocialFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(LoginWithEmailFragment())
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(1).setEnabled(false)
        binding.bottomNavigationView.menu.getItem(3).setEnabled(false)

        selectedItem()
    }

    private fun selectedItem() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val itemId = item.itemId
            when (item.itemId) {
                R.id.email_item -> {
                    replaceFragment(LoginWithEmailFragment())
                }

                R.id.phone_item -> {
                    replaceFragment(LoginWithPhoneFragment())
                }

                R.id.social_item -> {
                    replaceFragment(LoginWithSocialFragment())
                }
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment?) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.frame_layout, fragment)
        }
        fragmentTransaction.commit()
    }
}