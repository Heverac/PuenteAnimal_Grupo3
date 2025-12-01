package com.example.puenteanimal_grupo3.viewmodel

import com.example.puenteanimal_grupo3.model.LoginErrores
import com.example.puenteanimal_grupo3.model.LoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.isNotEmpty
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puenteanimal_grupo3.data.remote.RetrofitInstanceUsuarios
import com.example.puenteanimal_grupo3.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel : ViewModel() {
    private val userRepository = UserRepository(RetrofitInstanceUsuarios.userApi)
    private val _estado = MutableStateFlow(LoginUIState())

    val estado : StateFlow<LoginUIState> = _estado
    fun onUsuarioChange(valor:String){
        _estado.update { it.copy(usuario = valor, errores = it.errores.copy(usuario = null)) }
    }
    fun onClaveChange(valor:String){
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }
    fun validar(userSessionViewModel: UserSessionViewModel, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {

            _estado.update { it.copy(isLoading = true) }

            val estadoActual = _estado.value

            try {
                // Llamar a la API de login
                val usuarioRemoto = userRepository.login(
                    nombreUsuario = estadoActual.usuario,
                    password = estadoActual.clave
                )
                userSessionViewModel.setUser(usuarioRemoto)

                _estado.update {
                    it.copy(
                        isLoading = false,
                        errores = LoginErrores(),
                    )
                }

                onResult(true)   // avisar a la screen que todo salió bien

            } catch (e: HttpException) {
                // errores HTTP (401, 500, etc.)
                val mensaje = if (e.code() == 401) {
                    "Usuario o contraseña incorrectos"
                } else {
                    "Error del servidor (${e.code()})"
                }

                _estado.update {
                    it.copy(
                        isLoading = false,
                        errores = it.errores.copy(usuario = mensaje)
                    )
                }
                onResult(false)

            } catch (e: IOException) {
                // problema de red / conexión
                _estado.update {
                    it.copy(
                        isLoading = false,
                        errores = it.errores.copy(usuario = "Error de conexión")
                    )
                }
                onResult(false)
            }
        }
    }
}