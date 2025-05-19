Subcapa Excepciones
Aquí colocaremos las clases que representan errores específicos del dominio. 
Las Excepciones permiten manejar situaciones inesperadas dentro de la lógica 
de negocio, asegurando que el sistema responda de manera controlada.
Relaciones con otras subcapas del mismo nivel:
- Son utilizadas por Entities, Aggregates y ValueObjects para validar reglas de negocio.
- Pueden ser capturadas por Ports, asegurando una comunicación segura con la infraestructura.
Relaciones con otras capas (límite):
- Son manejadas por la capa Application, que define cómo deben ser tratadas.
- Pueden ser registradas en la capa Infrastructure, facilitando auditoría y monitoreo.
