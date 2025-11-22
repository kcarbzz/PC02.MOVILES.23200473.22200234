package com.example.pc02moviles2320047322200234.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pc02moviles2320047322200234.presentation.components.EquipoItem
import com.example.pc02moviles2320047322200234.presentation.viewmodel.EquipoViewModel

@Composable
fun ListadoScreen(viewModel: EquipoViewModel = viewModel()) {
    val equipos by viewModel.equipos.collectAsState()

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(equipos) {
            equipo -> EquipoItem(equipo = equipo)
        }
    }
}
