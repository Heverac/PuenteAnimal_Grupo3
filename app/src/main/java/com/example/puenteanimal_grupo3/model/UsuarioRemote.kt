package com.example.puenteanimal_grupo3.model


data class UsuarioRemote(
    val idUsuario: Int,
    val nombreUsuario: String,
    val nombre: String,
    val email: String,
    val password:String,
    val direccion: String?,
    val admin: Boolean
)


