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
Las funcionalidades clave incluyen:  

✅ **Gestión de atracciones y espectáculos**  
- Control de acceso según restricciones de **edad, peso y altura**.  
- Disponibilidad de atracciones por **temporada o clima**.  

✅ **Administración de empleados**  
- Asignación de **roles y turnos** (operadores, cajeros, cocineros, etc.).  
- Validación de capacitación según el nivel de riesgo de cada atracción.  

✅ **Venta y validación de tiquetes**  
- Diferentes tipos de **tiquetes** (Básico, Familiar, Oro, Diamante).  
- Compra de **FastPass** para acceso rápido a atracciones.  
- Registro de uso de tiquetes para evitar fraudes.

- ## Estructura del Proyecto
- 📦 src/
├── 📁 principal/
│   └── 📄 Principal.java 
├── 📁 atracciones/
│   ├── 📄 Atraccion.java
│   ├── 📄 AtraccionCultural.java
│   ├── 📄 AtraccionMecanica.java 
│   ├── 📄 Espectaculo.java
│   ├── 📄 Temporada.java 
│   └── 📄 Ubicacion.java 
├── 📁 tiquetes/
│   ├── 📄 Tiquete.java
│   ├── 📄 TiqueteBasico.java
│   ├── 📄 TiqueteFamiliar.java
│   └── 📄 (Otras clases de tiquetes Oro, Diamante, etc.)
├── 📁 empleados/
│   ├── 📄 Empleado.java
│   ├── 📄 Administrador.java 
│   ├── 📄 Cajero.java
│   └── 📄 (Otros roles: Cocinero, OperadorMecánico, etc.)
├── 📁 tests/
│   └── 📄 AtraccionTest.java

## Funcionalidades Destacadas

✅ Consultar requisitos de atracciones:
- Verificar altura, peso y restricciones de salud en atracciones mecánicas.
- Validar edad mínima en atracciones culturales.

✅ Gestión de empleados:
- Asignar turnos y lugares de trabajo.
- Restringir funciones según capacitación (ej: un cajero no puede operar una atracción).

✅ Venta de tiquetes:
- Comprar entradas en línea o en taquillas físicas.
- Validar acceso según categoría del tiquete y requisitos de atracción.

## Pruebas Unitarias

El archivo AtraccionTest.java incluye pruebas para:

- Atracciones mecánicas: Verificación de altura, peso y condiciones de salud.
- Atracciones culturales: Validación de edad mínima.
- Espectáculos: Disponibilidad según fechas de temporada.

Ejemplo de salida:
Prueba Mecanica 1 - No cumple con la altura mínima, esperada (false), dada: false  
Prueba Cultural 2 - Cumple con la edad mínima, esperada (true), dada: true  
