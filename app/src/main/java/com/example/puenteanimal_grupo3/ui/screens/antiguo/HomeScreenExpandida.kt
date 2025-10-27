package com.example.puenteanimal_grupo3.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.puenteanimal_grupo3.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenExpandida() {
    Scaffold(
        //Agrega el texto que se desee en la parte de arriba de la pantalla, en este caso
        //el nombre de la aplicacion
        topBar = {
            TopAppBar(title = { Text("Puente Animal version expandida") })
        }
        //Ajusta los espacios a utilizar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(30.dp),

            //Distancia vertical entre elementos
            verticalArrangement = Arrangement.spacedBy(20.dp),
            //Alineamiento horizontal de los elementos
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Texto básico para mostrar en pantalla
            Text(text = "¡Bienvenido a nuestro santuario!")
            //botón sin accion asignada por el momento
            Button(onClick = { /* acción futura */ }) {
                Text("¡Apadrína!")
            }
            //Agregado para el que se muestre el logo en la pantalla
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.imagen_exp),
                contentDescription = "Imagen expandidad para la App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenExpandidaPreview() {
    HomeScreenExpandida()
}
