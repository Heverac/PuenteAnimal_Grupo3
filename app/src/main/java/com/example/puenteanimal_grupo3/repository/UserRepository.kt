package com.example.puenteanimal_grupo3.repository

import com.example.puenteanimal_grupo3.data.remote.UserApiService
import com.example.puenteanimal_grupo3.model.LoginRequest
import com.example.puenteanimal_grupo3.model.UsuarioRemote


class UserRepository (private val api: UserApiService) {

    suspend fun login(nombreUsuario: String, password: String): UsuarioRemote {
        val request = LoginRequest(nombreUsuario = nombreUsuario,password = password)
        return api.login(request)
    }
    suspend fun apadrinarAnimal(usuarioActual: UsuarioRemote, animalId: Int): UsuarioRemote {
        val listaNueva = (usuarioActual.idAnimalesApadrinados + animalId).distinct()

        val usuarioActualizado = usuarioActual.copy(
            idAnimalesApadrinados = listaNueva
        )

        return api.updateUsuario(usuarioActual.idUsuario, usuarioActualizado)
    }
}
