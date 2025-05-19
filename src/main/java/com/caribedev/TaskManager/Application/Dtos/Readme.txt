Subcapa de DTOs (Data Transfer Objects)
Aquí colocaremos las clases que facilitan la transferencia de datos entre las diferentes capas de la aplicación.
Actúan como intermediarios entre los Commands, Queries y la capa de presentación, asegurando que los datos 
sean estructurados de manera adecuada antes de ser enviados o recibidos.
Relaciones con otras subcapas del mismo nivel:
- Es utilizado por los Casos de Uso para transformar los datos antes de enviarlos a la capa de presentación.
- Puede ser utilizado por Commands y Queries para estructurar los datos antes de enviarlos a la capa 
de dominio o infraestructura.
Relaciones con otras capas (límite):
- Se comunica con la capa de presentación, asegurando que los datos sean estructurados correctamente antes 
de ser mostrados al usuario.
- Puede interactuar con la capa de infraestructura, asegurando que los datos sean correctamente formateados
 antes de ser almacenados o recuperados.
