Subcapa Entities
Aquí colocaremos las clases que representan los objetos con identidad dentro del dominio. 
Las Entities tienen un identificador único y persisten a lo largo del tiempo, manteniendo 
su estado y comportamiento.
Relaciones con otras subcapas del mismo nivel:
- Se agrupan dentro de Aggregates, asegurando la consistencia de los datos.
- Pueden contener ValueObjects para representar atributos inmutables.
- Interactúan con Ports, permitiendo la comunicación con la capa de infraestructura.
Relaciones con otras capas (límite):
- Son utilizadas por la capa Application, que las manipula a través de los casos de uso.
- Se comunican con la capa Infrastructure mediante repositorios y adaptadores.
