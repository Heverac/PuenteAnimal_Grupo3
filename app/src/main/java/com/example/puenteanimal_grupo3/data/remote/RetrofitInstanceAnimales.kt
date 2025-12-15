package com.example.puenteanimal_grupo3.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstanceAnimales {
    private const val BASE_URL = "http://10.0.2.2:8081/"

    private val client = OkHttpClient.Builder().build()

    val animalApi: AnimalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimalApiService::class.java)
    }
}