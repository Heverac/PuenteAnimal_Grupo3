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
fun SettingsScreen() { // solo “Settings” al medio
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings")
    }
}
