package com.example.puenteanimal_grupo3.navigation
//sealeda class para definir rutas tipo-safe
sealed class Screen(val route: String) {

    //rutas simples sin argumentos son data object


    //Ruta a la pantalla de inicio
    data object Home : Screen("home_page")
    data object Profile : Screen("profile_page")
    data object Settings : Screen("settings_page")

    /** Ejemplo de una ruta a pantalla de detalles que requiere un itemId
     *
     * @param itemId el id del elemento a mostrar en la pantalla de detalles
     */

    data class Detail(val itemId : String) : Screen("detail_page/{itemId"){
        fun buildRoute():String { //esta funcion da la ruta con el argumento
            return route.replace("{itemId",itemId)
        }
    }



}