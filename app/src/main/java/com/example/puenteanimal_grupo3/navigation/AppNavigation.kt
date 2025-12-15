package com.example.puenteanimal_grupo3.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.puenteanimal_grupo3.data.remote.RetrofitInstanceAnimales
import com.example.puenteanimal_grupo3.model.AnimalRemote
import com.example.puenteanimal_grupo3.repository.AnimalRepository
import com.example.puenteanimal_grupo3.repository.UserRepository
import com.example.puenteanimal_grupo3.ui.screens.AnimalesScreen
import com.example.puenteanimal_grupo3.ui.screens.ApadrinarScreen
import com.example.puenteanimal_grupo3.ui.screens.HomeScreen
import com.example.puenteanimal_grupo3.ui.screens.InfoScreen
import com.example.puenteanimal_grupo3.ui.screens.LoginScreen
import com.example.puenteanimal_grupo3.ui.screens.ProfileScreen
import com.example.puenteanimal_grupo3.ui.screens.StartScreen
import com.example.puenteanimal_grupo3.ui.screens.components.BottomBar
import com.example.puenteanimal_grupo3.viewmodel.AnimalViewModel
import com.example.puenteanimal_grupo3.viewmodel.LoginViewModel
import com.example.puenteanimal_grupo3.viewmodel.UserSessionViewModel
import kotlinx.coroutines.launch

val loginViewModel = LoginViewModel()

@Composable
fun AppNavigation(
    userSessionViewModel: UserSessionViewModel,
    userRepository: UserRepository
) {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()

    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val showBottomBar = currentRoute in setOf("home", "perfil", "animales", "info", "apadrinar")

    // --- Animales (GET /animales una sola vez) ---
    val animalApi = RetrofitInstanceAnimales.animalApi
    val animalRepository = AnimalRepository(animalApi)
    val animalViewModel = remember { AnimalViewModel(animalRepository) }

    LaunchedEffect(Unit) {
        animalViewModel.cargarAnimales()
    }

    val animales = animalViewModel.animales
    val idsApadrinados = userSessionViewModel.currentUser?.idAnimalesApadrinados ?: emptyList()

    Scaffold(
        bottomBar = { if (showBottomBar) BottomBar(navController) }
    ) { inner ->

        NavHost(
            navController = navController,
            startDestination = Screen.Start.route,
            modifier = Modifier.padding(inner)
        ) {
            composable(route = Screen.Start.route) {
                StartScreen(navController = navController)
            }

            composable(route = Screen.Login.route) {
                LoginScreen(
                    navController = navController,
                    viewModelLogin = loginViewModel,
                    userSessionViewModel = userSessionViewModel
                )
            }

            composable("home") {
                HomeScreen(navController = navController)
            }

            composable(route = Screen.Profile.route) {
                ProfileScreen(userSessionViewModel = userSessionViewModel)
            }

            composable(route = Screen.Animales.route) {
                AnimalesScreen(
                    navController = navController,
                    animales = animales,
                    idsApadrinados = idsApadrinados
                )
            }

            composable(route = Screen.Info.route) {
                InfoScreen(
                    navController = navController,
                    userSessionViewModel = userSessionViewModel
                )
            }

            composable("apadrinar") {
                ApadrinarScreen(
                    navController = navController,
                    animales = animales,
                    onAgregarApadrinado = { animal, _ ->

                        val usuario = userSessionViewModel.currentUser
                            ?: return@ApadrinarScreen


                        coroutineScope.launch {
                            val actualizado = userRepository.apadrinarAnimal(
                                usuarioActual = usuario,
                                animalId = animal.idAnimal
                            )
                            userSessionViewModel.updateUser(actualizado)
                        }
                    }
                )
            }
        }
    }
}