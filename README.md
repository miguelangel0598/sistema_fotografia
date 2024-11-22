# Sistema de Facturación

Este proyecto es un **Sistema de Facturación** desarrollado en **Java** utilizando **NetBeans** como IDE y **MySQL** como base de datos. El sistema está diseñado para gestionar clientes, productos, servicios, ventas y reportes de manera eficiente, proporcionando una solución integral para el manejo administrativo de un negocio.

---

## Estructura del Proyecto

El proyecto está organizado en carpetas para mantener el código limpio y modular:

### 1. **Configuración**
- Contiene la clase responsable de establecer la conexión con la base de datos MySQL.
- Archivo principal: `ConexionBD`.

### 2. **Controlador**
- Incluye los controladores que manejan la lógica del sistema, conectando los modelos con los formularios.
- Controladores:
  - `ControladorCliente`: Lógica para la gestión de clientes.
  - `ControladorProducto`: Lógica para la gestión de productos.
  - `ControladorReportes`: Manejo de reportes personalizados.
  - `ControladorServicios`: Gestión de servicios y planes.
  - `ControladorVentas`: Lógica para el registro y cálculo de ventas.

### 3. **Formularios**
- Contiene el diseño de las interfaces gráficas del sistema.
- Formularios:
  - `BuscarComprobante`: Interfaz para buscar comprobantes existentes.
  - `FormularioClientes`: Gestión de clientes (registro, edición, eliminación).
  - `FormularioProducto`: Gestión de productos.
  - `FormularioReportesFechas`: Generación de reportes por rangos de fechas.
  - `FormularioServicios`: Gestión de servicios y planes.
  - `FormularioVentas`: Registro y visualización de ventas.
  - `MenuPrincipal`: Panel principal con acceso a las diferentes funcionalidades del sistema.

### 4. **Modelos**
- Define las clases modelo con sus respectivos atributos, getters y setters.
- Modelos:
  - `ModeloCliente`: Representación de la entidad cliente.
  - `ModeloProducto`: Representación de la entidad producto.
  - `ModeloServicio`: Representación de la entidad servicio.

---

## Funcionalidades

1. **Gestión de Clientes**:
   - Registro, edición y eliminación de clientes.
   - Búsqueda y listado de clientes registrados.

2. **Gestión de Productos**:
   - Registro de nuevos productos.
   - Actualización de stock y datos.
   - Listado de productos disponibles.

3. **Gestión de Servicios**:
   - Registro de servicios y planes asociados.
   - Modificación de precios y detalles.

4. **Facturación**:
   - Creación y gestión de facturas.
   - Registro de ventas con cálculo automático de totales.

5. **Reportes**:
   - Generación de reportes personalizados por rango de fechas.

---

## Requisitos

- **Java Development Kit (JDK)**: Versión 8 o superior.
- **NetBeans IDE**: Compatible con Maven.
- **MySQL**: Versión 8.0.
- **XAMPP**: Para gestionar MySQL con phpMyAdmin (opcional).

---

## Instalación y Ejecución

1. **Configurar la Base de Datos**:
   - Importar el archivo SQL proporcionado para configurar las tablas necesarias en MySQL.
   - Actualizar las credenciales de la base de datos en la clase `ConexionBD`.

2. **Configurar el Proyecto**:
   - Abrir el proyecto en NetBeans.
   - Asegurarse de tener las dependencias necesarias en el archivo `pom.xml`.

3. **Ejecutar el Sistema**:
   - Ejecutar la clase principal del sistema para acceder al menú principal.

---

## Autor

Miguel Ángel Abreu Tejada  
Proyecto desarrollado para un estudio de fotografía como parte de un sistema de facturación.  

---
