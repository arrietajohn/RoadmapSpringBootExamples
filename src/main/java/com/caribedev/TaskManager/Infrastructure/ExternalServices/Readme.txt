Subcapa ExternalServices
Aquí colocaremos las clases que gestionan la comunicación con servicios externos, 
como APIs de terceros, sistemas de pago y proveedores de datos.
Relaciones con otras subcapas del mismo nivel:
- Puede interactuar con Messaging, enviando y recibiendo eventos de sistemas externos.
- Se relaciona con Repositories, proporcionando acceso a datos externos que pueden 
  ser almacenados localmente.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, permitiendo la integración de servicios 
  externos en los casos de uso.
- Puede interactuar con la capa Domain a través de los Ports, asegurando que la 
  lógica de negocio permanezca desacoplada de los detalles técnicos.
