package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.puenteanimal_grupo3.data.SessionManager
import com.example.puenteanimal_grupo3.navigation.Screen
import com.example.puenteanimal_grupo3.viewmodel.UserSessionViewModel
import kotlinx.coroutines.launch


@Composable
fun InfoScreen(navController: NavController,
               userSessionViewModel: UserSessionViewModel
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- Título general ---
        Text(
            text = "Información",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        // --- Sección: Preguntas Frecuentes (FAQ) ---
        Text(
            text = "Preguntas frecuentes",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = buildString {
                append("• ¿Qué es Puente Animal?\n")
                append("Puente Animal es una app donde podrás apadrinar animales rescatados y seguir su progreso.\n\n")
                append("• ¿Cómo funciona el apadrinamiento?\n")
                append("Próximamente podrás elegir un animal, aportar mensualmente y recibir actualizaciones 🐾.\n\n")
                append("• ¿Dónde se encuentra el refugio?\n")
                append("En Santiago, Chile. Pero puedes apoyar desde cualquier parte ❤️")
            },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
        )


        // --- Sección: Contacto ---
        Text(
            text = "Contacto",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Aportes Transferencia - Cuenta Rut - Numero de cuenta 12344567-0",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "📧 contacto@puenteanimal.cl\n📞 +56 9 1234 5678",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(32.dp))

        // --- Botón de Cerrar Sesión ---
        Button(
            onClick = {
                scope.launch {

                    sessionManager.clearSession()
                    userSessionViewModel.logout()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            ),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Cerrar sesión",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}