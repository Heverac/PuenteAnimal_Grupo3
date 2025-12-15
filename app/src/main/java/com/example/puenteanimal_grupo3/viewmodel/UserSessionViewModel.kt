package com.example.puenteanimal_grupo3.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.puenteanimal_grupo3.model.UsuarioRemote
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class UserSessionViewModel : ViewModel() {

    var currentUser by mutableStateOf<UsuarioRemote?>(null)
        private set

    fun setUser(user: UsuarioRemote) {
        currentUser = user
    }

    fun logout() {
        currentUser = null
    }
    fun updateUser(usuario: UsuarioRemote) {
        currentUser = usuario
    }

}
