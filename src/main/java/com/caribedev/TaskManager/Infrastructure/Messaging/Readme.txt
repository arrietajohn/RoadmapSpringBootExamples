Subcapa Messaging
Aquí colocaremos las clases que gestionan la comunicación asíncrona dentro del sistema,
utilizando tecnologías como Kafka, RabbitMQ o eventos internos.
Relaciones con otras subcapas del mismo nivel:
- Se relaciona con ExternalServices, permitiendo la integración con sistemas de 
   mensajería externos.
- Puede interactuar con Persistence, asegurando que los mensajes sean almacenados 
   y procesados correctamente.
Relaciones con otras capas (límite):
- Se comunica con la capa Application, permitiendo la ejecución de eventos dentro 
   de los casos de uso.
- Puede interactuar con la capa Domain, asegurando que los eventos respeten las 
   reglas de negocio.


