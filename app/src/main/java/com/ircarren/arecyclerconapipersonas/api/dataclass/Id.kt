package com.ircarren.arecyclerconapipersonas.api.dataclass


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)