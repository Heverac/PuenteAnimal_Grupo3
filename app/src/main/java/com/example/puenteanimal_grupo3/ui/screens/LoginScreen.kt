package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.puenteanimal_grupo3.viewmodel.LoginViewModel
import com.example.puenteanimal_grupo3.R
import com.example.puenteanimal_grupo3.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    viewModelLogin: LoginViewModel
) {
    val estado by viewModelLogin.estado.collectAsState()

    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Puente Animal") }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id=R.drawable.logo),
                    contentDescription = "Logo App",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "¡Bienvenido a Puente Animal!")
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = estado.usuario,
                    onValueChange = viewModelLogin::onUsuarioChange,
                    label = { Text("Usuario") },
                    isError = estado.errores.usuario != null,
                    supportingText = {
                        estado.errores.usuario?.let {
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = estado.clave,
                    onValueChange = viewModelLogin::onClaveChange,
                    label = { Text("Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = estado.errores.clave != null,
                    supportingText = {
                        estado.errores.clave?.let {
                            Text(it, color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (viewModelLogin.validar()) {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Login.route) { inclusive = true } // elimina login del back stack
                                launchSingleTop = true
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Iniciar Sesión") }

            }
        }
    }
}

@Preview(name = "LoginScreen", widthDp = 360, heightDp = 800)
@Composable
fun PreviewLoginScreen(){
    val viewModel = LoginViewModel()
    val navController = rememberNavController()
    LoginScreen(navController = navController, viewModel)
}
