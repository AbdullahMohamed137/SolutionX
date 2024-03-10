package com.example.solutionx

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class LogCheckFlavor(private val context: Context) {

    fun logFlavor(){
        when (BuildConfig.FLAVOR) {
            "logCat" -> {
                Log.d("MyApp", "This is a log message.")
            }
            "logWriter" -> {
                val file ="log.txt"
                val data = "This is a log message."
                val fileOutPutStream : FileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutPutStream.write(data.toByteArray())
                val logFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "log.txt")
                logFile.appendText("This is a log message.")
            }
            else -> {

            }
        }
    }
}