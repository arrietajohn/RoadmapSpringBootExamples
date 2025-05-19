Subcapa Config
Aquí colocaremos las clases que gestionan la configuración global de la aplicación.
 Esta subcapa permite definir parámetros como conexiones a bases de datos, 
 configuración de seguridad y ajustes generales del sistema.
Relaciones con otras subcapas del mismo nivel:
- Es utilizada por Persistence para definir parámetros de conexión a bases de datos.
- Se relaciona con Security, proporcionando configuraciones de autenticación y autorización.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, proporcionando configuraciones necesarias 
para la ejecución de los casos de uso.
- Puede interactuar con la capa Presentation, permitiendo ajustes dinámicos en 
la interfaz de usuario.
