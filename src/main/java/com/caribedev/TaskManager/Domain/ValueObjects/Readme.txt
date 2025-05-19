Subcapa ValueObjects
Aquí colocaremos las clases que representan conceptos dentro del dominio sin identidad 
propia. Los ValueObjects son inmutables y se comparan por sus valores en lugar de 
por referencias.
Relaciones con otras subcapas del mismo nivel:
- Son utilizados dentro de Entities y Aggregates para modelar atributos complejos.
- No interactúan directamente con Ports, ya que no requieren persistencia independiente.
Relaciones con otras capas (límite):
- Son manipulados por la capa Application, pero no modificados directamente.
- Se almacenan en la capa Infrastructure como parte de las entidades.
