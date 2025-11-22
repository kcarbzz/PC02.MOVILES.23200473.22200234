package com.example.pc02moviles2320047322200234.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pc02moviles2320047322200234.data.Equipo
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EquipoViewModel : ViewModel() {
    var nombre by mutableStateOf("")
    var anioFundacion by mutableStateOf("")
    var titulosGanados by mutableStateOf("")
    var imagenUrl by mutableStateOf("")

    // Estado para comunicar resultado (éxito/error) a la UI
    var statusMessage by mutableStateOf("")

    fun addEquipo() {
        // Validación mínima
        if (nombre.isBlank()) {
            statusMessage = "El nombre del equipo es obligatorio"
            return
        }

        val anioFundacionInt = anioFundacion.toIntOrNull() ?: 0
        val titulosGanadosInt = titulosGanados.toIntOrNull() ?: 0

        val equipo = Equipo(
            nombre = nombre,
            anio_fundacion = anioFundacionInt,
            titulos_ganados = titulosGanadosInt,
            imagen_url = imagenUrl
        )

        Firebase.firestore.collection("equipos")
            .add(equipo)
            .addOnSuccessListener {
                statusMessage = "Equipo registrado correctamente"
                // limpiar campos
                nombre = ""
                anioFundacion = ""
                titulosGanados = ""
                imagenUrl = ""
            }
            .addOnFailureListener { e ->
                statusMessage = "Error al registrar: ${e.message}"
            }
    }

    fun clearStatus() {
        statusMessage = ""
    }
}
