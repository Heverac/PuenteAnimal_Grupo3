package com.example.puenteanimal_grupo3.data.remote

import com.example.puenteanimal_grupo3.model.AnimalRemote
import retrofit2.http.GET

interface AnimalApiService {
    @GET("animales")
    suspend fun getAnimales(): List<AnimalRemote>
}