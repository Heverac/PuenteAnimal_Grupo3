package com.example.puenteanimal_grupo3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puenteanimal_grupo3.model.AnimalRemote
import com.example.puenteanimal_grupo3.repository.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(
    private val repository: AnimalRepository
) : ViewModel() {

    var animales by mutableStateOf<List<AnimalRemote>>(emptyList())
        private set

    fun cargarAnimales() {
        viewModelScope.launch {
            try {
                animales = repository.getAnimales()
            } catch (e: Exception) {
                animales = emptyList()
            }
        }
    }
}
