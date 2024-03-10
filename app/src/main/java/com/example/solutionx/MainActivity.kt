package com.example.solutionx

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import com.example.solutionx.activities.CountryActivity
import com.example.solutionx.activities.CurrencyActivity
import com.example.solutionx.activities.FilterActivity
import com.example.solutionx.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var logCheckFlavor: LogCheckFlavor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logCheckFlavor.logFlavor()

        binding.btnCountry.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CountryActivity::class.java)
            startActivity(intent)
        })
        binding.btnCurrency.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CurrencyActivity::class.java)
            startActivity(intent)
        })
        binding.btnFilters.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        })


    }

}