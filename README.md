
![Programação-Desafío](https://github.com/genesysR-dev/2066-desafio-persistiendo-datos-artistas-canciones/assets/91544872/6675312c-06e9-4a44-a869-683c332dcd71)

# Desafío
Aplicación para almacenar datos de nuestros artistas y canciones preferidas en una base de datos relacional, pudiendo buscar información por artistas y consultar datos sobre los mismos a través de integración con la API de ChatGPT.

Clase Artista, con los datos para representar el mismo;
Clase específica para representar las canciones;
Para el artista, implementación de un enum, para definir el tipo de artista, por ejemplo: solista, dúo o banda;
Creación del proyecto a través del sitio [Spring Initializr](https://start.spring.io/), donde ya se añadieron las dependencias de Spring Data JPA y PostgreSQL;
Clase principal con el menú, con las opciones deseadas, como: registrar artista, registrar canción, buscar canciones por artistas, etc;

## 🔨 Objetivos del proyecto

- El objetivo del proyecto es practicar la modelización de clases y relaciones utilizando Spring Data JPA;
- Es importante describir e implementar correctamente la relación entre Artista y Canción, dado que un artista puede estar asociado a más de una canción;
- Una canción solo debe ser guardada en la base de datos si el Artista ha sido previamente registrado;
- Practicaremos consultas derivadas y JPQL para verificar si el artista ya está registrado y buscar canciones por un determinado artista;
- Realizaremos la integración con la API de ChatGPT para buscar información sobre un determinado artista.

## 📷 Capturas de pantalla
![Imagen de WhatsApp 2024-05-20 a las 23 54 44_f31a9513](https://github.com/DavidVF7/Desafio-Java-y-Spring-persistiendo-datos-artistas-y-canciones/assets/103916971/b82a34a3-52c4-4624-8dd5-3283034636a9)
![Imagen de WhatsApp 2024-05-20 a las 23 54 44_537d2197](https://github.com/DavidVF7/Desafio-Java-y-Spring-persistiendo-datos-artistas-y-canciones/assets/103916971/3fcc9f33-62a7-4346-bdd0-70712f0737a3)
