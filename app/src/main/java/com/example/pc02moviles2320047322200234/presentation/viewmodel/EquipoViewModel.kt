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

    fun addEquipo() {
        val anioFundacionInt = anioFundacion.toIntOrNull() ?: 0
        val titulosGanadosInt = titulosGanados.toIntOrNull() ?: 0

        val equipo = Equipo(
            nombre = nombre,
            anio_fundacion = anioFundacionInt,
            titulos_ganados = titulosGanadosInt,
            imagen_url = imagenUrl
        )
        Firebase.firestore.collection("equipos").add(equipo)
        nombre = ""
        anioFundacion = ""
        titulosGanados = ""
        imagenUrl = ""
    }
}
