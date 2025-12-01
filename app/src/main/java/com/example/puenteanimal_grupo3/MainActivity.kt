package com.example.puenteanimal_grupo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puenteanimal_grupo3.navigation.AppNavigation

import com.example.puenteanimal_grupo3.viewmodel.UserSessionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                val userSessionViewModel: UserSessionViewModel = viewModel()
                AppNavigation(userSessionViewModel = userSessionViewModel)
            }
        }
    }



/*
fun GeneralPreview() {
    PuenteAnimal_Grupo3Theme {

    }
}*/