package com.example.solutionx

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class LogCheckFlavor(private val context: Context) {

    fun logFlavor(tag : String, message : String){
        when (BuildConfig.FLAVOR) {
            "logCat" -> {
                Log.d(tag, message)
            }
            "logWriter" -> {
                val file ="log.txt"
                val fileOutPutStream : FileOutputStream = context.openFileOutput(file, Context.MODE_PRIVATE)
                fileOutPutStream.write(message.toByteArray())
                val logFile = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "log.txt")
                logFile.appendText(message)
            }
            else -> {

            }
        }
    }
}