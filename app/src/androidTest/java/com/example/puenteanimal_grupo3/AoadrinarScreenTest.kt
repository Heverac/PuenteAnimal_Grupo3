package com.example.puenteanimal_grupo3

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.example.puenteanimal_grupo3.ui.screens.ApadrinarScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class ApadrinarScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun botonApadrinarExisteYEsClickable() {
        composeTestRule.setContent {

            val navController = rememberNavController()

            ApadrinarScreen(
                navController = navController,
                onAgregarApadrinado = { _, _ -> } // función vacía
            )
        }

        composeTestRule.onNodeWithText("Apadrinar").assertIsDisplayed()
        composeTestRule.onNodeWithText("Apadrinar").performClick()
    }
}

