Subcapa de Queries
Aquí colocaremos las clases que encapsulan las operaciones de lectura dentro del sistema. 
A diferencia de los Commands, las Queries no modifican el estado de la aplicación, 
sino que recuperan información de manera eficiente.
Relaciones con otras subcapas del mismo nivel:
- Es procesada por un Query Handler, que ejecuta la lógica necesaria para obtener los datos.
- Se relaciona con la subcapa de Casos de Uso, que la invoca para obtener información relevante.
- Puede interactuar con DTOs para estructurar los datos antes de enviarlos a la capa de presentación.
Relaciones con otras capas (límite):
- Se comunica con la capa de infraestructura, accediendo a bases de datos y otros servicios externos.
- Puede interactuar con la capa de presentación, enviando los datos estructurados para su visualización.