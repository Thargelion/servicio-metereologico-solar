[![Build Status](https://travis-ci.org/Thargelion/servicio-metereologico-solar.svg?branch=master)](https://travis-ci.org/Thargelion/servicio-metereologico-solar)

# servicio-metereologico-solar
Pronóstico del clima en Vulcano para la próxima década.

## Endpoints:

| Path        | Verb          | Info      |
| ------------- |:-------------:| ---------:|
| /clima/:id | GET | Datos del clima para el dia :id|
| /planeta | GET      |   Ver listado de planetas |
| /planeta/:id | GET | Ver planeta |
| /pronostico/:dias | GET | Calcular el pronóstico para los fututos :dias dias |
| /analisis | GET | Analiza los datos para responder por días de lluvia, óptimos, etc. |
| /reset | GET | Devolver a los planetas a la posición inicial |
| /reset_full | GET | Tira todo y devuelve a los planetas a la posición inicial |

## Deploy local:

### Variables de entorno:

| Clave        | Tipo          | Info      |
| ------------- |:-------------:| ---------:|
| MONGO_USER | string | Usuario de conexión a mongo |
| MONGO_PASSWORD | string      |   Contraseña del usuario |
| MONGO_DATABASE | string | Base de datos a usar |
| MONGO_SRV | string | URL base de conexión ej: cluster0-uwcs4.mongodb.net |

### Docker

Ejecutar docker build . -t nombre. Incluir --build-arg por cada variable de entorno si no se usan las globales. Ejemplo:
```bash
--build-arg MONGO_USER=spock --build-arg MONGO_PASSWORD=contraseña
```

Ejecutar docker run. Incluir como CLAVE=VALOR en un archivo de texto las variables para levantarlas en tiempo de ejecución en caso de no querer usar las globales.

```bash
docker run --env-file=variables.docker
```

## Diseño

La aplicación está dividida en tres grandes paquetes. De esta forma se separó el problema en tres dominios con el objetivo de puedan cambiar independientemente sin mayores modificaciones.

### Api
_Dominio de presentación_

Aquí están definidos los controllers, rutas y se modelan las respuestas

### App
_Dominio del negocio_

Aquí está la lógica del negocio de la aplicación. Modelos, servicios y la interacción entre ellos.

### Lib
_Dominio de implementación de herramientas externas_

Aquí están las herramientas que se construyeron para que *app* pueda realizar los cálculos necesarios para responder a la lógica del negocio. Aquí se implementó Math3 de Apache para resolver las cuestiones matemáticas. Y se implementó también la conexión con mongo.

## Solución

La aplicación plantea el almacenamiento de los pronósticos en dos etapas. Primero se calculan las posiciones de los planetas empleando rotación de un punto en un plano cartesiano.

Segundo, se crean los diferentes climas haciendo un análisis de las posiciones. Primero se buscan que los puntos estén alineados, y luego si el sol pertenece o no al triángulo que forman estos puntos. Esto se realiza mediante la búsqueda del rango de la matriz que forman los vectores de los 3 planetas + el sol y mediante el cálculo de las áreas de los triángulos que se forman.

Finalmente, para calcular cuál es el día de mayor nivel de lluvia se buscó qué área formada por el triángulo que tiene al sol dentro de ella es la más grande.

## Tecnologías usadas

- [Java 8](https://www.java.com/es/download/faq/java8.xml)

- [Java Spark](http://sparkjava.com/)

- [Mongo DB](https://www.mongodb.com/)

- [Math3](https://commons.apache.org/proper/commons-math/)

- [slf4j](https://www.slf4j.org/)

- [Travis](https://travis-ci.com/)