package com.example.solutionx.models

import java.io.Serializable

data class Country(val id : Int,
              val name : String,
              val currency : String,
              val code : String,
              val phone_code : String,
              val flag: String,
              val isSelected : Boolean) : Serializable{
}