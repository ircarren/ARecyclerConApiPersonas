package com.ircarren.arecyclerconapipersonas.api

import com.ircarren.arecyclerconapipersonas.api.dataclass.ApiDataClass
import retrofit2.Call
import retrofit2.http.GET

interface APersonaApiService {

    @GET("api/?results=50")
    fun listPersonas() : Call<ApiDataClass>
}