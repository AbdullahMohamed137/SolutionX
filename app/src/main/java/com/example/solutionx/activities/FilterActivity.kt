package com.example.solutionx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.Adapter
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityCountryBinding
import com.example.solutionx.models.Filter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.InputStream

class FilterActivity : AppCompatActivity() {

    private lateinit var customAdapter: Adapter
    private lateinit var listOfFilter: List<Filter>

    private lateinit var binding: ActivityCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listOfFilter = loadFiltersFromJson()
        customAdapter = Adapter(this, emptyList(), emptyList(), listOfFilter)
        binding.rvCountry.adapter = customAdapter
        binding.rvCountry.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun loadFiltersFromJson() : List<Filter> {
        val countryObject : InputStream = assets.open("filters.json")
        val jsonString = countryObject.bufferedReader().use { it.readText() }
        countryObject.close()

        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        val gson = Gson()
        val dataList : List<Filter> = gson.fromJson(dataArray.toString(), object : TypeToken<List<Filter>>(){}.type)
        return dataList
    }
}