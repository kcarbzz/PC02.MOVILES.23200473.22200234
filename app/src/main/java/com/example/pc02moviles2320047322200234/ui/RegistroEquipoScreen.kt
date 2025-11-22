package com.example.pc02moviles2320047322200234.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pc02moviles2320047322200234.presentation.viewmodel.EquipoViewModel

@Composable
fun RegistroEquipoScreen(equipoViewModel: EquipoViewModel) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = equipoViewModel.statusMessage) {
        val msg = equipoViewModel.statusMessage
        if (msg.isNotBlank()) {
            snackbarHostState.showSnackbar(message = msg)
            equipoViewModel.clearStatus()
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .padding(16.dp)) {

            OutlinedTextField(
                value = equipoViewModel.nombre,
                onValueChange = { equipoViewModel.nombre = it },
                label = { Text("Nombre del equipo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = equipoViewModel.anioFundacion,
                onValueChange = { equipoViewModel.anioFundacion = it },
                label = { Text("Año de fundación") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = equipoViewModel.titulosGanados,
                onValueChange = { equipoViewModel.titulosGanados = it },
                label = { Text("Títulos ganados") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = equipoViewModel.imagenUrl,
                onValueChange = { equipoViewModel.imagenUrl = it },
                label = { Text("URL de la imagen") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = { equipoViewModel.addEquipo() }, modifier = Modifier.fillMaxWidth()) {
                Text("Registrar Equipo")
            }
        }
    }
}
