package com.example.puenteanimal_grupo3.navigation

sealed class NavigationEvent {


    /** Evento para navegar a distintos destinos
     *
     * @param route Es el destino al que quieres navegar.
     *
     * @param popUpToRoute Indica hasta qué pantalla de la pila de navegación se
     * debe "hacer pop"(es decir, eliminar pantallas por encima de esa).
     *
     * @param inclusive Va junto con popUpToRoute.
     *
     * @param singleTop  Evita duplicar pantallas en la pila.
     */

    data class NavigateTo(
        val route:Screen, //recibe un objeto AppDestinations
        val popUpToRoute:Screen?=null, //tambien acepta un objeto AppDestination
        val inclusive :Boolean = false,
        val singleTop : Boolean=false
    ) : NavigationEvent()

    //Evento para volver a la pantalla anterior de la pila

    object PopBackStack : NavigationEvent()

    /**
     * Evento para navegar hacia arriba en la jerarquia
     * puede equivaler a [PopBackStack] si no tiene un padre definido
     * por ejemplo si setting tiene de padre home, aunque la pila anterior
     * sea perfil volvera a home
     */
    object NavigateUp : NavigationEvent()













}