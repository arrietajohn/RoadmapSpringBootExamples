Subcapa de Casos de Uso
Aquí colocaremos las clases que gestionan la ejecución de operaciones específicas dentro del sistema. 
Cada caso de uso representa una acción concreta, como la creación, actualización o eliminación de 
entidades, asegurando que las reglas de negocio se apliquen correctamente.
Relaciones con otras subcapas del mismo nivel:
- Utiliza Commands para modificar datos y Queries para obtener información.
- Se apoya en DTOs para transformar los datos antes de enviarlos a la capa de presentación.
- Puede interactuar con la subcapa de Servicios para coordinar procesos más complejos.
Relaciones con otras capas (límite):
- Actúa como intermediario entre la capa de presentación y la lógica interna del sistema.
- Se comunica con la capa de infraestructura para acceder a bases de datos y otros servicios externos.