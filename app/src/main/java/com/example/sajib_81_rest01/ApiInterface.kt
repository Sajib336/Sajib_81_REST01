package com.example.sajib_81_rest01

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface  {
    val retroFit = Retrofit.Builder()
        .baseUrl("https://api.escuelajs.co/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retroFit.create(ApiService::class.java)
}