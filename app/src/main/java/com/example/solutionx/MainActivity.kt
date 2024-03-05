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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //logSomething()

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

    fun logSomething(){
        when{

            BuildConfig.FLAVOR == "logCat" -> {
                Log.d("MyApp", "This is a log message.")
            }
            BuildConfig.FLAVOR == "logWriter" -> {
                val file ="log.txt"
                val data = "This is a log message."
                val fileOutPutStream : FileOutputStream
                fileOutPutStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutPutStream.write(data.toByteArray())

                val logFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "log.txt")
                logFile.appendText("This is a log message.")
            }
            else ->{

            }
        }
    }
}