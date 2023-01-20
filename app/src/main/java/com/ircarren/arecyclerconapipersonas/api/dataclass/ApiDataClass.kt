package com.ircarren.arecyclerconapipersonas.api.dataclass


import com.google.gson.annotations.SerializedName

data class ApiDataClass(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)