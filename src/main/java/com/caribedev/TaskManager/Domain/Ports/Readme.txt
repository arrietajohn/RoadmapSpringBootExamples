Subcapa Ports (Interfaces de Dominio)
Aquí colocaremos las interfaces que permiten la comunicación entre la capa Domain 
y las capas superiores. Los Ports definen contratos que deben ser implementados 
por la capa Infrastructure, asegurando que el dominio permanezca independiente de 
detalles técnicos.
Relaciones con otras subcapas del mismo nivel:
- Son utilizados por Aggregates y Entities para acceder a servicios externos.
- No contienen lógica de negocio, solo definiciones de métodos.
Relaciones con otras capas (límite):
- Son implementados por la capa Infrastructure, que proporciona adaptadores y repositorios.
- Son invocados por la capa Application, que los usa en los casos de uso.
