package com.example.solutionx

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logSomething()
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