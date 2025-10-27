package com.example.puenteanimal_grupo3.navigation
//sealeda class para definir rutas tipo-safe
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Settings

sealed class Screen(val route: String, val label: String? = null, val icon: ImageVector? = null) {
    // No aparece en bottom bar:
    data object Login    : Screen("login")

    // Aparecen en bottom bar:
    data object Home     : Screen("home",     "Inicio",    Icons.Filled.Home)
    data object Profile  : Screen("perfil",   "Perfil",    Icons.Filled.Person)
    data object Animales : Screen("animales", "Animales",  Icons.Filled.Pets)
    data object Settings : Screen("settings", "Settings",  Icons.Filled.Settings)
}

val BottomNavItems = listOf(Screen.Home, Screen.Profile, Screen.Animales, Screen.Settings)
