package com.example.solutionx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}