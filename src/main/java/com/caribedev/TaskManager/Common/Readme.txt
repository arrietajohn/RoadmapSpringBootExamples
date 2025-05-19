Capa Common (Corte Transversal)
Aquí colocaremos las clases y componentes que contienen funcionalidades transversales, compartidas por todas 
las capas del sistema. Su propósito es proporcionar servicios comunes, como logging, validaciones, 
manejo de excepciones, seguridad y herramientas de utilidad, evitando la duplicación 
de código y mejorando la mantenibilidad de la aplicación.
Relaciones con otras capas:
- Application: Proporciona herramientas que facilitan la ejecución de los casos de uso y servicios, 
como validaciones, formatos de datos y excepciones personalizadas.
- Domain: Puede ofrecer utilidades para el manejo de entidades, como comparaciones avanzadas y 
funciones auxiliares.
- Infrastructure: Contiene funcionalidades de acceso a recursos externos, como gestión de archivos, 
conexiones API y configuración general del sistema.
- Presentation: Proporciona soporte para validaciones de entrada, estructuras de respuesta
 y manejo de errores en la interfaz de usuario.
Esta capa garantiza que las funcionalidades comunes sean reutilizables en todo el sistema 
sin generar acoplamiento innecesario, contribuyendo a una arquitectura más modular y escalable.
