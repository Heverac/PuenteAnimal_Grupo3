package com.example.puenteanimal_grupo3.model

import androidx.annotation.DrawableRes

data class Animal(
    val nombre: String,
    @DrawableRes val fotoRes: Int,
    val nota: String = ""
)
