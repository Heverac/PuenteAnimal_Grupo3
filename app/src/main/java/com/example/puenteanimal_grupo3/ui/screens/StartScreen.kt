package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.puenteanimal_grupo3.data.SessionManager
import com.example.puenteanimal_grupo3.navigation.Screen // ajusta el paquete
import kotlinx.coroutines.flow.first

@Composable
fun StartScreen(navController: NavController) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    LaunchedEffect(Unit) {
        val isLoggedIn = sessionManager.isLoggedIn.first()
        if (isLoggedIn) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Start.route) { inclusive = true }
                launchSingleTop = true
            }
        } else {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Start.route) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

    // Pantalla de carga simple mientras se resuelve
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}