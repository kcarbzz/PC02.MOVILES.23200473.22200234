package com.example.pc02moviles2320047322200234.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pc02moviles2320047322200234.data.model.Equipo

@Composable
fun EquipoItem(equipo: Equipo) {
    Card(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(equipo.imagen_url)
                    .crossfade(true)
                    .build(),
                contentDescription = "Escudo de ${equipo.nombre}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = equipo.nombre, style = MaterialTheme.typography.headlineSmall)
                Text(text = "Fundado en: ${equipo.anio_fundacion}")
                Text(text = "Títulos: ${equipo.titulos_ganados}")
            }
        }
    }
}
