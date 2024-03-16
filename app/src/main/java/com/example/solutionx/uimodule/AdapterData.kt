package com.example.solutionx.uimodule

import com.google.gson.annotations.SerializedName

data class AdapterData(
    var name: String = "", var code: String = "",
    @SerializedName(value = "currency", alternate = ["sign"])
    var currency: String = "",
    var isSelected: Boolean = false
)