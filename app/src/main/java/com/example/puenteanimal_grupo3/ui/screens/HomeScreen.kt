package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puenteanimal_grupo3.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun HomeScreen(){
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("¡Bienvenido a Puente Animal!")
    }
}

/*@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}*/