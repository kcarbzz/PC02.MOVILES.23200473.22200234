package com.example.pc02moviles2320047322200234

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc02moviles2320047322200234.presentation.viewmodel.EquipoViewModel
import com.example.pc02moviles2320047322200234.ui.theme.PC02MOVILES2320047322200234Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PC02MOVILES2320047322200234Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RegistroEquipoScreen()
                }
            }
        }
    }
}

@Composable
fun RegistroEquipoScreen(equipoViewModel: EquipoViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
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
        Button(
            onClick = { equipoViewModel.addEquipo() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar Equipo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PC02MOVILES2320047322200234Theme {
        RegistroEquipoScreen()
    }
}
