package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.puenteanimal_grupo3.navigation.Screen
import com.example.puenteanimal_grupo3.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(
    navController: NavController, //Controlador de navegación, realiza la navegacion real
    viewModel: MainViewModel= viewModel () //Emite los eventos de navegacion
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed) //para abrir y cerrar un menu lateral
    val scope = rememberCoroutineScope() //forma segura de realizar acciones que toman tiempo

    ModalNavigationDrawer( //Crea el menu lateral deslizante
        drawerState = drawerState,
        drawerContent = {//Contenido del menu deslizante
            ModalDrawerSheet {
                Text(
                    text = "Menú",
                    modifier = Modifier.padding(all = 16.dp)
                )
                NavigationDrawerItem(
                    label = { Text(text = "Ir a Perfil") },
                    selected = false,
                    onClick = {
                        // Acción al hacer clic
                        scope.launch { drawerState.close() }
                        viewModel.navigateTo(Screen.Profile)
                    }
                )
            }
        }
    ) {
        Scaffold( //Parte principal de Drawer
            topBar = {//Descipcion parte de arriba
                TopAppBar(
                    title = { Text(text = "Pantalla Home") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(//
                modifier = Modifier
                    .padding(paddingValues = innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "¡Bienvenido a Puente Animal!")
                Spacer(modifier = Modifier.height(height = 16.dp))
                Button(onClick = { viewModel.navigateTo(Screen.Settings) }) {
                    Text(text = "Ir a Configuración")
                }
            }
        }
    }
}
