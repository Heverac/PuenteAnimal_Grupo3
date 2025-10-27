package com.example.puenteanimal_grupo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puenteanimal_grupo3.navigation.AppNavigation

import com.example.puenteanimal_grupo3.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }
}


/*
fun GeneralPreview() {
    PuenteAnimal_Grupo3Theme {

    }
}*/