package com.example.solutionx.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.Adapter
import com.example.solutionx.databinding.ActivityListBinding
import com.example.solutionx.uimodule.AdapterData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListActivity : AppCompatActivity() {

    private lateinit var customAdapter: Adapter
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val listGson = intent.getStringExtra("list")?: "[]"
        val typeToken = object:TypeToken<ArrayList<AdapterData>>(){}.type
        val newList = Gson().fromJson<ArrayList<AdapterData>>(listGson, typeToken)
        newList.first().isSelected = true

        customAdapter = Adapter(this, newList)
        binding.rvList.adapter = customAdapter
        binding.rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }


}