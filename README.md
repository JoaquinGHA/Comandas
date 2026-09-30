# Comandas 🍔

API REST desarrollada en Java con Spring Boot para la gestión de comandas 
de un restaurante. Proyecto de portfolio centrado en programación orientada 
a objetos, persistencia con PostgreSQL y arquitectura en capas.

## Descripción

Sistema de gestión de comandas con operaciones CRUD completas (crear, consultar, 
actualizar y eliminar). Modela un restaurante donde cada **cuenta** agrupa varios 
**productos** (hamburguesas, bebidas, postres...) y calcula su total automáticamente. 
Las hamburguesas admiten personalización con extras y guarnición.

## Conceptos aplicados

- **Clase abstracta** `Producto` como base con los atributos comunes (nombre, precio)
- **Herencia y polimorfismo** — Hamburguesa, Bebida, Postre, Entrante y Guarnición
- **Relaciones entre entidades** — una hamburguesa tiene varios extras (1:N) y 
  una cuenta agrupa varios productos
- **Spring Data JPA** — persistencia automática, las tablas se generan desde las entidades
- **Arquitectura en capas** — Entidad → Repository → Service → Controller
- **API REST** — endpoints GET, POST, PUT y DELETE para productos y cuentas
- **Cálculo de totales** — suma de productos y extras en la capa de servicio

## Tecnologías

- Java 17
- Spring Boot 4.1.1
- Spring Data JPA
- PostgreSQL
- Maven
- API REST (probada con Postman)

## Configuración

El proyecto requiere una base de datos PostgreSQL llamada `comandas`. 
Copia `application.properties.example`, renómbralo a `application.properties` 
y completa tus credenciales.