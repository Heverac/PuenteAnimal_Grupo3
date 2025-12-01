package com.example.puenteanimal_grupo3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.puenteanimal_grupo3.R
import com.example.puenteanimal_grupo3.model.Animal

data class Animal(val nombre: String, val fotoRes: Int)

val animalesDestacados = listOf(
    Animal("Capitán", R.drawable.perro1),
    Animal("Luna", R.drawable.gato1),
    Animal("Milo",    R.drawable.perro2, "Juguetón"),
    Animal("Nala",    R.drawable.loro,  "Cariñosa"),
    Animal("Celeste",    R.drawable.oveja,  "Solitaria")
)
@Composable
fun AnimalCard(animal: Animal, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(140.dp)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = animal.fotoRes),
            contentDescription = animal.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = animal.nombre,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
val avisosRefugio = listOf(
    "Campaña de vacunación este sábado 🩺",
    "Jornada de adopción - Plaza Central 🐶",
    "Se necesitan mantas y alimento 💙"
)
@Composable
fun AvisoCard(texto: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = texto,
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
@Composable
fun ImpactoBlock(
    totalAtencionesMes: Int = 48,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "Impacto del apadrinamiento",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Este mes, $totalAtencionesMes animales recibieron atención gracias a los padrinos ❤️",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        // Título arriba
        Text(
            text = "¡Bienvenido a Puente Animal!",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )


        Spacer(Modifier.height(16.dp))
        Text(
            text = "Avisos del refugio",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.height(8.dp))

        avisosRefugio.forEach { AvisoCard(it) }
        Spacer(Modifier.height(16.dp))

        // Sección de animales
        Text(
            text = "Animales destacados",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )


        Spacer(Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(animalesDestacados) { animal ->
                AnimalCard(animal)
            }
        }
        Spacer(Modifier.height(24.dp))
        Text(
            text = "Apadrína aquí 🐾",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )
        Button(
            onClick = { navController.navigate("apadrinar") }
        ) {
            Text("Apadrinar")
        }

        Spacer(Modifier.height(16.dp))
        ImpactoBlock(totalAtencionesMes = 48)

    }

}

/*

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController: NavHostController)
}
 */