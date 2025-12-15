package com.example.puenteanimal_grupo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puenteanimal_grupo3.data.remote.RetrofitInstanceUsuarios
import com.example.puenteanimal_grupo3.navigation.AppNavigation
import com.example.puenteanimal_grupo3.repository.UserRepository
import com.example.puenteanimal_grupo3.ui.theme.AppTheme

import com.example.puenteanimal_grupo3.viewmodel.UserSessionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val userSessionViewModel: UserSessionViewModel = viewModel()


                val userRepository = remember {
                    UserRepository(RetrofitInstanceUsuarios.userApi)
                }

                AppNavigation(
                    userSessionViewModel = userSessionViewModel,
                    userRepository = userRepository
                )
            }
        }
    }
}



/*
fun GeneralPreview() {
    PuenteAnimal_Grupo3Theme {

    }
}*/