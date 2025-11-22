package com.example.pc02moviles2320047322200234.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pc02moviles2320047322200234.data.model.Equipo
import com.example.pc02moviles2320047322200234.data.repository.EquipoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EquipoViewModel : ViewModel() {
    private val repository = EquipoRepository()

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos

    init {
        viewModelScope.launch {
            _equipos.value = repository.getEquipos()
        }
    }
}
