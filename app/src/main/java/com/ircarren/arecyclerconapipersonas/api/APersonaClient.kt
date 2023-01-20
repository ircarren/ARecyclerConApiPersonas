package com.ircarren.arecyclerconapipersonas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APersonaClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(APersonaApiService::class.java)
}