package com.example.puenteanimal_grupo3.repository

import com.example.puenteanimal_grupo3.data.remote.AnimalApiService
import com.example.puenteanimal_grupo3.model.AnimalRemote

class AnimalRepository(
    private val api: AnimalApiService
) {
    suspend fun getAnimales(): List<AnimalRemote> {
        return api.getAnimales()
    }
}
