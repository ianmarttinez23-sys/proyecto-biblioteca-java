# DISEÑO DE LA APLICACIÓN
## Objetivo
Desarrollar una aplicación de consola en Java que permita gestionar un pequeño catálogo de libros para una biblioteca.

El programa permitirá registrar libros, consultar su estado y obtener estadísticas básicas.
## Requisitos mínimos
La aplicación debe permitir:
- Añadir un libro
- Mostrar libros
- Buscar libro
- Prestar libro
- Devolver libro
- Mostrar estadísticas
- Salir de la aplicación

La aplicación debe ejecutarse desde la consola.
## Datos de la aplicación
Cada libro almacenará:
- Título
- Autor
- Estado (Disponible / Prestado)

## Estructura prevista
Funciones principales
- mostrarMenu()
- añadirLibro()
- mostrarLibros()
- buscarLibro()
- prestarLibro()
- devolverLibro()
- mostrarEstadisticas()

Variables principales
- libros[][]
- TITULO
- AUTOR
- ESTADO
- numeroLibros

## Flujo
Inicio

↓

Menú

↓

Usuario elige opción

↓

Ejecutar función

↓

volver al menú

↓

Salir.

## Limitaciones
-Los datos se pierden al cerrar la aplicación
- No existe persistencia
- No se pueden eliminar libros
- No existe límite configurable del catálogo

## Futuras mejoras
- Guardar en archivos
- Exportar catálogo
- Añadir categorias
- Sistema de usuario para controlar préstamos