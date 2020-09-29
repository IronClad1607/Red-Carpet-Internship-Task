package com.ishaanjain.redcarpetinternship.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiCall = retrofit.create(NewAPIService::class.java)
}