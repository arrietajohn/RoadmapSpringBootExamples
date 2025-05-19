Subcapa Aggregates
Aquí colocaremos las clases que agrupan Entities y ValueObjects bajo un mismo contexto 
de consistencia. Un Aggregate define un conjunto de objetos que deben mantenerse 
coherentes entre sí, asegurando que las reglas de negocio se cumplan.
Relaciones con otras subcapas del mismo nivel:
- Contienen Entities y ValueObjects, asegurando la integridad de los datos.
- Se comunican con Ports, permitiendo la persistencia y recuperación de información.
Relaciones con otras capas (límite):
- Son manipulados por la capa Application, que los utiliza en los casos de uso.
- Se almacenan y recuperan desde la capa Infrastructure mediante repositorios.
