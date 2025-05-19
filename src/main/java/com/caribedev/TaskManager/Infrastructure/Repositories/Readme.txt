Subcapa Repositories
Aquí colocaremos las clases que implementan el acceso a datos mediante el patrón 
de repositorio, asegurando que la lógica de persistencia esté separada de la 
lógica de negocio.
Relaciones con otras subcapas del mismo nivel:
- Se relaciona con Persistence, proporcionando una capa de abstracción sobre el 
  acceso a bases de datos.
- Puede interactuar con ExternalServices, permitiendo la sincronización de datos 
  con sistemas externos.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, permitiendo la ejecución de consultas y 
  modificaciones de datos dentro de los casos de uso.
- Puede interactuar con la capa Domain a través de los Ports, asegurando que la 
  lógica de negocio permanezca desacoplada de la infraestructura de persistencia.
