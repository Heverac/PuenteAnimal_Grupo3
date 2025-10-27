package com.example.puenteanimal_grupo3.viewmodel


import com.example.puenteanimal_grupo3.model.LoginErrores
import com.example.puenteanimal_grupo3.model.LoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.isNotEmpty
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _estado = MutableStateFlow(LoginUIState())

    val estado : StateFlow<LoginUIState> = _estado

    fun onUsuarioChange(valor:String){
        _estado.update { it.copy(usuario = valor, errores = it.errores.copy(usuario = null)) }
    }

    fun onClaveChange(valor:String){
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun validar(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            _estado.update { it.copy(isLoading = true) }

            delay(2000)

            val estadoActual = _estado.value
            val errores = LoginErrores(
                usuario = if (!estadoActual.usuario.equals("user")) "Usuario incorrecto" else null,
                clave = if (!estadoActual.clave.equals("1234")) "Clave incorrecta" else null
            )

            val hayErrores = listOfNotNull(
                errores.usuario,
                errores.clave
            ).isNotEmpty()

            _estado.update { it.copy(errores = errores, isLoading = false) }

            // 5. Devuelve resultado al composable
            onResult(!hayErrores)
        }
    }

}