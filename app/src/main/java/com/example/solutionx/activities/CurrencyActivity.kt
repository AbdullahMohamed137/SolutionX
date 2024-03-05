package com.example.solutionx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.Adapter
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityCountryBinding
import com.example.solutionx.models.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.InputStream

class CurrencyActivity : AppCompatActivity() {

    private lateinit var customAdapter: Adapter
    private lateinit var listOfCurrency: List<Currency>
    private lateinit var binding: ActivityCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOfCurrency = loadCurrenciesFromJson()
        customAdapter = Adapter(this, emptyList(), listOfCurrency, emptyList())
        binding.rvCountry.adapter = customAdapter
        binding.rvCountry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    fun loadCurrenciesFromJson() : List<Currency>{
        val currencyObject : InputStream = assets.open("currencies.json")
        val jsonString = currencyObject.bufferedReader().use { it.readText() }
        currencyObject.close()

        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        val gson = Gson()
        val dataList : List<Currency> = gson.fromJson(dataArray.toString(), object : TypeToken<List<Currency>>(){}.type)
        return dataList
    }
}