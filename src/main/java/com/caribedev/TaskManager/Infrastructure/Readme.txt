Capa Infrastructure
Aquí colocaremos las clases y componentes que gestionan la interacción con 
servicios externos, bases de datos, seguridad y configuración del sistema. 
La capa Infrastructure actúa como un puente entre la lógica de negocio y los 
recursos externos, asegurando que la aplicación pueda comunicarse con bases de datos, 
APIs y otros sistemas sin acoplarse directamente a ellos.
Relaciones con otras capas:
- Application: Implementa los Ports definidos en la capa de dominio, permitiendo 
  la comunicación con servicios externos.
- Domain: No interactúa directamente con esta capa, sino a través de los Ports.
- Presentation: No se comunica directamente con esta capa, sino a través de Application
