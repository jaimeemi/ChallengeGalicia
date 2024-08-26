* Quiero Destacar que mis metodos estan construidos con Argumentos que recibo inmediatamente
  Pero cuando superan los 3 o 5 Argumentos, suelo trabajar con Objetos
  Para manjeralos entre el Controlador y El service de mejor manera

* Este codigo es todo idea Mia. Honesto soy, si he buscado algunas cosas en internet
  ya que no aplico todo y no guardo toda la informacion de todo el codigo en mi cabeza

* Suelos hacer los test lo mas facil posible.


    *********************************************************************

Java Code Challenge

Nos gustaría tener un servicio web RESTful que almacene información de caminos y estaciones (en
memoria está bien) para optimización de viajes.
Una estación esta definida por un nombre. Mientras que un camino, se encuentra definido por
un costo, una estación origen, y otra estación destino (bidireccional). El objetivo es ofrecer una
solución para consultar sobre el camino óptimo para transitar desde una estación A, hasta una
estación B minimizando costos.

1. Por favor, completar en Spring Boot (Java o Kotlin) y en no mas de 2 días consecutivos.
2. Completar el proyecto en Github, para que podamos revisar el código.
3. No usar SQL.
Requerido:
• Tests de integración.
• Aplicación dockerizada.
• Java 11 o superior.
• Claridad del código.
• Correctitud en diseño de arquitectura.
Se valorará positivamente:
• Uso de TDD.
• Desarrollo incremental de la solución mediante el uso de commits.
• Aplicación de los principios SOLID.
• Documentacion.

Especificación del servicio
PUT /stations/$station_id
<img alt="1.PNG" src="imagenes%2F1.PNG"/>
Codigo 1: PUT station

En dónde:
• station_id Es de tipo ’long’ identificador de una nueva estación. •
name Es de tipo ’string’ espcificando el nombre de la estación.
Body: { "name":string }

PUT /paths/$path_id
<img alt="2.PNG" src="imagenes%2F2.PNG"/>

Codigo 2: PUT path

En dónde:
• path_id Es de tipo ’long’ identificador de un nuevo camino.
• source_id Es de tipo ’long’ espcificando el id de la estacion origen.
• destination_id Es de tipo ’long’ espcificando el id de la estacion destino.
• cost Es de tipo ’double’ espcificando el costo de transitar el camino.
Asumir que no se va a registrar mas de un camino entre dos estaciones y que todos los caminos
son bidireccionales.

GET /paths/$source_id/$destination_id
<img alt="3.PNG" src="imagenes%2F3.PNG"/>

Codigo 3: GET shortest path

Los ids de las estaciones que conforman el camino optimo en base al valor del "cost" desde
source_id hasta destination_id junto al valor del costo total.

Algunos ejemplos simples podrian ser:

<img alt="4.PNG" src="imagenes%2F4.PNG"/>


    *********************************************************************

