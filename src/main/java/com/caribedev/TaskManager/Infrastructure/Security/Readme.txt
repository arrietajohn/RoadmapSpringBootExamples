Subcapa Security
Aquí colocaremos las clases que gestionan la autenticación, autorización y protección 
de datos dentro del sistema.
Relaciones con otras subcapas del mismo nivel:
- Se relaciona con Config, asegurando que las políticas de seguridad sean configuradas 
  correctamente.
- Puede interactuar con Repositories, permitiendo el almacenamiento seguro de 
  credenciales y permisos.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, asegurando que los casos de uso respeten 
  las reglas de seguridad.
- Puede interactuar con la capa Presentation, proporcionando mecanismos de 
  autenticación y autorización para los usuarios.
