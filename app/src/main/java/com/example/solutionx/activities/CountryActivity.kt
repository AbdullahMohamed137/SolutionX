package com.example.solutionx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.Adapter
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityCountryBinding
import com.example.solutionx.databinding.ActivityMainBinding
import com.example.solutionx.models.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.InputStream

class CountryActivity : AppCompatActivity() {

    private lateinit var customAdapter: Adapter
    private lateinit var listOfCountry: List<Country>
    private lateinit var binding: ActivityCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOfCountry = loadCountriesFromJson()
        customAdapter = Adapter(this, listOfCountry, emptyList(), emptyList())
        binding.rvCountry.adapter = customAdapter
        binding.rvCountry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun loadCountriesFromJson() : List<Country>{
        val countryObject : InputStream = assets.open("countries.json")
        val jsonString = countryObject.bufferedReader().use { it.readText() }
        countryObject.close()

        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        val gson = Gson()
        val dataList : List<Country> = gson.fromJson(dataArray.toString(), object : TypeToken<List<Country>>(){}.type)
        return dataList
    }
}