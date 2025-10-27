package com.example.puenteanimal_grupo3.model

data class LoginUIState(
    val usuario : String = "",
    val clave : String = "",
    val errores : LoginErrores = LoginErrores(),
)

