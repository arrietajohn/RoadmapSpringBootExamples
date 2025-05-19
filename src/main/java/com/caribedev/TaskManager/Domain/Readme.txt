Capa Domain
Aquí colocaremos las clases que representan el núcleo de la lógica de negocio de la 
aplicación. La capa Domain encapsula las reglas y comportamientos del sistema, 
asegurando que los datos y procesos sean coherentes con el modelo del negocio.
Relaciones con otras capas:
- Application: Expone entidades y reglas de negocio para que los casos de uso las manipulen.
- Infrastructure: Define interfaces (Ports) que permiten la comunicación con 
  servicios externos sin acoplarse a implementaciones específicas.
- Presentation: No interactúa directamente con esta capa, sino a través de Application.


