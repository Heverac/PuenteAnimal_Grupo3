package com.example.puenteanimal_grupo3.data.remote

import com.example.puenteanimal_grupo3.model.LoginRequest
import com.example.puenteanimal_grupo3.model.UsuarioRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("usuarios/login")
    suspend fun login(
        @Body request: LoginRequest
    ): UsuarioRemote
}