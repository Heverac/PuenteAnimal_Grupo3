package com.example.puenteanimal_grupo3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.puenteanimal_grupo3.navigation.NavigationEvent
import com.example.puenteanimal_grupo3.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _navigationEvents= MutableSharedFlow<NavigationEvent>() //Emite el mensaje de adonde navegar

    val navigationEvents: SharedFlow<NavigationEvent> = _navigationEvents.asSharedFlow() //Emite el evento en publico para la UI



    //Funciones para la navegacion definidas en NavigationEvent
    fun navigateTo(screen: Screen){    //A la ruta seleccionada
        CoroutineScope(Dispatchers.Main).launch {
            _navigationEvents.emit(NavigationEvent.NavigateTo(route = screen))
        }
    }
    fun navigateBack(){  //A la anterior
        CoroutineScope(Dispatchers.Main).launch {
            _navigationEvents.emit(NavigationEvent.PopBackStack)
        }
    }
    fun navigateUp(){   //Hacia arriba
        CoroutineScope(Dispatchers.Main).launch{
            _navigationEvents.emit(NavigationEvent.NavigateUp)
        }
    }
}