package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puenteanimal_grupo3.model.AnimalRemote




@Composable
fun ApadrinarScreen(
    navController: NavHostController,
    animales: List<AnimalRemote>,
    onAgregarApadrinado: (AnimalRemote, String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedAnimal by remember { mutableStateOf<AnimalRemote?>(null) }
    var montoAporte by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Apadrinar animal",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = selectedAnimal?.nombre ?: "Selecciona un animal")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                animales.forEach { animal ->
                    DropdownMenuItem(
                        text = { Text(animal.nombre) },
                        onClick = {
                            selectedAnimal = animal
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = montoAporte,
            onValueChange = { montoAporte = it },
            label = { Text("Monto de aporte") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val animal = selectedAnimal
                if (animal != null && montoAporte.isNotBlank()) {
                    onAgregarApadrinado(animal, montoAporte)
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = false }
                    }
                }
            },
            modifier = Modifier.align(Alignment.End),
            enabled = selectedAnimal != null && montoAporte.isNotBlank()
        ) {
            Text("Agregar")
        }
    }
}
