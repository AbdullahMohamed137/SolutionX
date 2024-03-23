package com.example.solutionx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.solutionx.activities.FragmentActivity
import com.example.solutionx.activities.ListActivity
import com.example.solutionx.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var logCheckFlavor: LogCheckFlavor = LogCheckFlavor(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfCountry = loadDataFromJson("countries.json")
        val listOfCurrency = loadDataFromJson("currencies.json")
        val listOfFilter = loadDataFromJson("filters.json")


        logCheckFlavor.logFlavor("testLog", "This is a log message you see me !?")

        binding.btnCountry.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("list", listOfCountry)
            startActivity(intent)
        })
        binding.btnCurrency.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("list", listOfCurrency)
            startActivity(intent)
        })
        binding.btnFilters.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("list", listOfFilter)
            startActivity(intent)
        })
        binding.btnFragments.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        })
    }

    private fun loadDataFromJson(fileName: String): String? {
        val listObject: InputStream = assets.open(fileName)
        val jsonString = listObject.bufferedReader().use { it.readText() }
        listObject.close()
        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        return dataArray.toString()
    }
}