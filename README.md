# Proyecto 1 - Diseño y Programación Orientada a Objetos (DPOO)  
Primer proyecto del curso **Diseño y Programación Orientada a Objetos**, basado en la gestión de un **parque de diversiones**.  

---

## Integrantes  
1. **Jerónimo López** - 202320969  
2. **Juan Esteban Piñeros** - 202412232  
3. **Daniel Diab** - 202212289  

---

## Descripción  
Este proyecto modela un **sistema de administración para un parque de atracciones**, aplicando **principios de POO** y patrones de diseño.  

## Funcionalidades Clave

- **Gestión de Atracciones y Espectáculos**  
  - Validación de acceso a atracciones mecánicas y culturales  
  - Evalúa si un cliente cumple con los requisitos de altura, peso o edad, y si tiene condiciones médicas que lo impidan.  
  - Disponibilidad según temporada o clima  
  - Consulta si una atracción o espectáculo está disponible en la fecha actual.  

- **Administración de Empleados**  
  - Se gestionan turnos diurnos y nocturnos para empleados con fecha, hora de inicio y fin.  
  - Verificación de turnos asignados  
  - Consultas personalizadas para saber si un empleado tiene turno en una fecha dada.  
  - Empleados como operadores mecánicos, cajeros o cocineros deben cumplir condiciones según su rol.  

- **Venta y Validación de Tiquetes**  
  - Soporte para múltiples tipos de tiquete:  
    - Básico  
    - Familiar  
    - Oro  
    - Diamante  
  - Consulta de tiquetes por cliente  
  - Muestra los tiquetes asociados a cada cliente y si ya han sido usados.  
  - Compra simulada de tiquetes  
  - Los tiquetes pueden incluir acceso a diferentes atracciones o beneficios como FastPass.  

## Estructura del proyecto

- **El sistema se organiza en distintos paquetes:**
	-	atracciones: Atracciones mecánicas, culturales y espectáculos.
	-	persona: Roles y turnos del personal del parque.
	-	tiquetes: Gestión de clientes, tipos de tiquetes y puntos de venta.
	-	principal: Lógica principal que conecta todos los módulos.
 
```bash
src/
├── principal/
│   └── Principal.java  
├── atracciones/
│   ├── Atraccion.java
│   ├── AtraccionCultural.java
│   ├── AtraccionMecanica.java
│   ├── Espectaculo.java 
│   ├── Temporada.java 
│   └── Ubicacion.java 
├── tiquetes/
│   ├── Tiquete.java 
│   ├── TiqueteBasico.java 
│   ├── TiqueteFamiliar.java
│   └── (Otras clases de tiquetes Oro, Diamante, etc.)
├── empleados/
│   ├── Empleado.java
│   ├── Administrador.java
│   ├── Cajero.java      
│   └── (Otros roles: Cocinero, OperadorMecánico, etc.)
tests/
    └── AtraccionTest.java 
```

## Menú Interactivo en Consola

La clase Principal ofrece un menú de interacción desde la consola para:
1.	Consultar requisitos de atracciones y verificar disponibilidad de espectáculos o atracciones.
2.	Consultar turnos de empleados y tiquetes de clientes.
3.	Ver clientes registrados y tiquetes por cliente.
4.	Registrar un nuevo cliente y realizar la compra de tiquetes.

## Ejemplo de Uso
-	Consulta si un cliente puede ingresar a una montaña rusa con altura/peso dados.
-	Verifica si un espectáculo se realizará en una fecha determinada.
-	Pregunta si el cajero “Pablo Mancera” tiene turno el 2 de abril de 2025.
-	Muestra los tiquetes del cliente “Juan Jimenez”.

## Pruebas Unitarias

El archivo AtraccionTest.java incluye pruebas para:

- Atracciones mecánicas: Verificación de altura, peso y condiciones de salud.
- Atracciones culturales: Validación de edad mínima.
- Espectáculos: Disponibilidad según fechas de temporada.

Ejemplo de salida:
- Prueba Mecanica 1 - No cumple con la altura mínima, esperada (false), dada: false  
- Prueba Cultural 2 - Cumple con la edad mínima, esperada (true), dada: true  
