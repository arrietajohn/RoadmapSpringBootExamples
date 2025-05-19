Subcapa de Servicios
Aquí colocaremos las clases que actúan como coordinadoras dentro de la capa de aplicación. Su función principal es 
gestionar la ejecución de los casos de uso y garantizar que las reglas de negocio se apliquen correctamente.
Relaciones con otras subcapas del mismo nivel:
- Se comunica con la subcapa de Casos de Uso, delegando la ejecución de operaciones específicas.
- Puede interactuar con Commands y Queries, enviando solicitudes para modificar o recuperar datos.
- Utiliza DTOs para estructurar los datos antes de enviarlos a la capa de presentación.
Relaciones con otras capas (límite):
- Recibe solicitudes desde la capa de presentación y las traduce en operaciones dentro de la aplicación.
- Se comunica con la capa de dominio, asegurando que las reglas de negocio sean respetadas.