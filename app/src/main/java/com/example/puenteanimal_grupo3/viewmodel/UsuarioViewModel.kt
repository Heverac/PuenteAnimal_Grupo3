package com.example.puenteanimal_grupo3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.puenteanimal_grupo3.model.UsuarioErrores
import com.example.puenteanimal_grupo3.model.UsuarioUiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.isNotEmpty
import kotlin.text.contains
import kotlin.text.isBlank

class UsuarioViewModel : ViewModel() {
    private val _estado = MutableStateFlow(UsuarioUiState())

    val estado : StateFlow<UsuarioUiState> = _estado

    fun onNombreChange(valor:String){
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    fun onCorreoChange(valor:String){
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun onClaveChange(valor:String){
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun onDireccionChange(valor:String){
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun onAceptarTerminosChange(valor: Boolean){
        _estado.update { it.copy(aceptaTerminos = valor) }
    }

    fun validarFormulario(): Boolean{
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            nombre = if (estadoActual.nombre.isBlank()) "Campo obligatorio" else null,
            correo = if (!estadoActual.correo.contains("@")) "Correo invalido" else null,
            clave = if (estadoActual.clave.length < 6) "Debe tener al menos 6 caracteres" else null,
            direccion = if (estadoActual.direccion.isBlank()) "Campo obligatorio" else null,
            aceptaTerminos = if (!estadoActual.aceptaTerminos) "Debes aceptar los términos" else null
        )



        val hayErrrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion,
            errores.aceptaTerminos
        ).isNotEmpty()

        _estado.update { it.copy( errores = errores) }

        return !hayErrrores
    }
    init {
        // Precarga de ejemplo
        _estado.update {
            it.copy(
                nombre = "Lucas Barrios",
                correo = "lucas@example.com",
                clave = "123456",
                direccion = "Santiago, Chile",
                aceptaTerminos = true
            )
        }
    }

    fun guardar(): Boolean {
        val ok = validarFormulario()

        return ok

    }

}