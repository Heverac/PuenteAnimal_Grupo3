# Puente Animal 🐾

Aplicación móvil enfocada en la adopción y apadrinamiento de animales rescatados, desarrollada con **Kotlin** y **Jetpack Compose**.

## Integrantes
- Hernán Vera
- Benjamín Donoso

## Funcionalidades principales
- Inicio de sesión con persistencia de usuario.
- Visualización de animales destacados y disponibles para apadrinar.
- Agregado y gestión de animales apadrinados.
- Pantalla de perfil con datos obtenidos desde API externa.
- Navegación con Bottom Navigation Bar.
- Uso de Material 3, Scaffold y arquitectura con ViewModel.

## Endpoints utilizados (API Usuarios y API Animasles)
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /usuarios/login | Validación de credenciales y respuesta con los datos del usuario |
| GET | /usuarios/{id} | Obtiene información del usuario autenticado |
| GET | /animales | Obtiene información de los animales para apadrinar |
| PUT | /usuarios/{id} | Actualiza la información de los animales apadrinados por el usuario  |

## Pasos para ejecutar el proyecto
1. Clonar el repositorio y abrir en Android Studio.
2. Ejecutar el microservicio de usuarios (puerto 8080) y animales (puerto 8081) con su base de datos de mySQL (Xampp).
3. Modificar la variable BASE_URL en caso de usar una IP distinta.
4. Ejecutar la app con el botón **Run** en Android Studio.

## Capturas del APK firmado y archivo .jks
<img width="1797" height="525" alt="image" src="https://github.com/user-attachments/assets/b6996e64-8084-4c71-8198-9ce1f44be862" />



