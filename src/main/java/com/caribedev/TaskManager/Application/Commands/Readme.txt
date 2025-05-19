Subcapa de Commands
Aquí colocaremos las clases que encapsulan las operaciones de escritura dentro del sistema. 
Cada Command representa una acción que modifica el estado de la aplicación, como la creación, 
actualización o eliminación de datos.
Relaciones con otras subcapas del mismo nivel:
- Es procesado por un Command Handler, que ejecuta la lógica correspondiente.
- Se relaciona con la subcapa de Casos de Uso, que lo invoca para realizar modificaciones en los datos.
- Puede interactuar con DTOs para estructurar los datos antes de enviarlos a la capa de dominio.
Relaciones con otras capas (límite):
- Se comunica con la capa de dominio, aplicando las reglas de negocio antes de modificar los datos.
- Puede interactuar con la capa de infraestructura para persistir los cambios en la base de datos.
