package com.example.puenteanimal_grupo3.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.puenteanimal_grupo3.ui.screens.AnimalesScreen
import com.example.puenteanimal_grupo3.ui.screens.HomeScreen
import com.example.puenteanimal_grupo3.ui.screens.LoginScreen
import com.example.puenteanimal_grupo3.ui.screens.ProfileScreen
import com.example.puenteanimal_grupo3.ui.screens.SettingsScreen
import com.example.puenteanimal_grupo3.ui.screens.components.BottomBar
import com.example.puenteanimal_grupo3.viewmodel.LoginViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val loginViewModel = LoginViewModel()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val showBottomBar = currentRoute in setOf("home", "perfil", "animales", "settings")

    Scaffold(
        bottomBar = { if (showBottomBar) BottomBar(navController) }
    ) { inner ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(inner)
        ) {
            composable("login")    { LoginScreen(navController, loginViewModel) }
            composable("home")     { HomeScreen() }
            composable("perfil")   { ProfileScreen() }
            composable("animales") { AnimalesScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}
