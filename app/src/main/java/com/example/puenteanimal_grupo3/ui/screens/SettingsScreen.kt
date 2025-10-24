package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.puenteanimal_grupo3.navigation.Screen
import com.example.puenteanimal_grupo3.viewmodel.MainViewModel

@Composable
fun SettingsScreen(
    navController: NavController,                      // Controlador de navegación para moverse entre pantallas
    viewModel: MainViewModel                           // ViewModel que centraliza la navegación (eventos)
) {
    // Estructura visual centralizada
    Column(
        modifier = Modifier
            .fillMaxSize()                             // Ocupar todo el alto disponible
            .padding(all = 16.dp),                     // Margen interno general
        verticalArrangement = Arrangement.Center,      // Centrar elementos verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centrar elementos horizontalmente
    ) {
        // Título o texto principal
        Text(text = "Pantalla de Configuración (Settings)")

        Spacer(modifier = Modifier.height(height = 24.dp)) // Espacio vertical

        // Botón para volver al Home
        Button(
            onClick = {
                viewModel.navigateTo(Screen.Home)       // Emitir evento de navegación al ViewModel
            }
        ) {
            Text(text = "Volver al Inicio")
        }

        Spacer(modifier = Modifier.height(height = 16.dp)) // Más espacio

        // Botón para ir al Perfil
        Button(
            onClick = {
                viewModel.navigateTo(Screen.Profile)    // Emitir evento para ir a perfil
            }
        ) {
            Text(text = "Ir a Perfil")
        }
    }
}
