package com.example.pc02moviles2320047322200234.data.repository

import com.example.pc02moviles2320047322200234.data.model.Equipo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class EquipoRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun getEquipos(): List<Equipo> {
        return try {
            val snapshot = db.collection("equipos").get().await()
            snapshot.toObjects(Equipo::class.java)
        } catch (e: Exception) {
            // En una app real, aquí manejarías el error de forma más elegante
            // (logs, crasheo controlado, etc.)
            emptyList()
        }
    }
}
