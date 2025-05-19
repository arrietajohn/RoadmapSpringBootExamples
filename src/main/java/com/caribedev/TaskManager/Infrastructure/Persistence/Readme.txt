Subcapa Persistence
Aquí colocaremos las clases que gestionan la persistencia de datos en bases de datos 
relacionales y no relacionales.
Relaciones con otras subcapas del mismo nivel:
- Se relaciona con Repositories, proporcionando acceso a los datos almacenados.
- Puede interactuar con Config, asegurando que las conexiones a bases de datos 
  sean configuradas correctamente.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, permitiendo la ejecución de consultas y 
   modificaciones de datos dentro de los casos de uso.
- Puede interactuar con la capa Domain a través de los Ports, asegurando que 
  la lógica de negocio permanezca desacoplada de la infraestructura de persistencia
