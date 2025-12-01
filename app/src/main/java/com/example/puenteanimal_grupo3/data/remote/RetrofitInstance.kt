package com.example.puenteanimal_grupo3.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceUsuarios {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    private val client = OkHttpClient.Builder().build()

    val userApi: UserApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }
}