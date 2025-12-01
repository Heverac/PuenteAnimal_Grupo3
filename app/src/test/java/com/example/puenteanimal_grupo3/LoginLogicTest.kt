package com.example.puenteanimal_grupo3


import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginLogicTest {


    private fun isValidLogin(username: String, password: String): Boolean {
        return username.isNotBlank() && password.isNotBlank()
    }

    @Test
    fun loginEsValidoCuandoUsuarioYClaveNoEstanVacios() {
        val result = isValidLogin("usuario", "1234")
        assertTrue(result)
    }

    @Test
    fun loginNoEsValidoCuandoUsuarioEstaVacio() {
        val result = isValidLogin("", "1234")
        assertFalse(result)
    }
}
