package com.example.puenteanimal_grupo3.data.remote

import com.example.puenteanimal_grupo3.model.LoginRequest
import com.example.puenteanimal_grupo3.model.UsuarioRemote
import retrofit2.http.*

interface UserApiService {
    @POST("usuarios/login")
    suspend fun login(@Body request: LoginRequest): UsuarioRemote

    @PUT("usuarios/{id}")
    suspend fun updateUsuario(
        @Path("id") id: Int,
        @Body usuario: UsuarioRemote
    ): UsuarioRemote
}
