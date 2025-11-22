package com.example.pc02moviles2320047322200234.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToRegistro: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Button(onClick = { onNavigateToRegistro() }, modifier = Modifier.fillMaxWidth()) {
            Text("Ir a Registro de Equipo")
        }
    }
}
