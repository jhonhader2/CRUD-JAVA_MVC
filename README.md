# CRUD Java MVC

Sistema de gestión de personas desarrollado en Java utilizando el patrón de diseño MVC (Modelo-Vista-Controlador).

## 🚀 Características

- Gestión completa de personas (CRUD)
- Interfaz gráfica desarrollada con Swing
- Validación de datos
- Persistencia en base de datos
- Implementación del patrón MVC
- Manejo de roles de usuario

## 🛠️ Tecnologías Utilizadas

- Java 8 o superior
- Swing para la interfaz gráfica
- JCalendar para el selector de fechas
- MySQL para la base de datos
- Patrón de diseño MVC

## 📋 Prerrequisitos

- JDK 8 o superior
- MySQL Server
- IDE compatible con Java (recomendado NetBeans)
- Biblioteca JCalendar (jcalendar-1.4.jar)

## 🔧 Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/jhonhader2/CRUD-JAVA_MVC.git
```

2. Importar el proyecto en NetBeans:
   - File -> Open Project
   - Seleccionar la carpeta del proyecto

3. Configurar la base de datos:
   - Crear una base de datos MySQL llamada `crud_java`
   - Ejecutar el script SQL proporcionado en `src/Scripts/schema.sql`

4. Configurar la conexión:
   - Verificar los parámetros de conexión en `Config/ConexionLocal.java`
   - Ajustar según tu configuración local

5. Agregar la biblioteca JCalendar:
   - Click derecho en el proyecto -> Properties
   - Libraries -> Add JAR/Folder
   - Seleccionar `jcalendar-1.4.jar`

## 📦 Estructura del Proyecto

```
src/
├── Config/
│   └── ConexionLocal.java
├── Controllers/
│   ├── PersonaController.java
│   └── RolController.java
├── Interface/
│   └── IGestorDatos.java
├── Models/
│   ├── Persona.java
│   └── Rol.java
├── Utils/
│   └── UIUtils.java
├── Views/
│   └── Personas.java
├── Scripts/
│   └── schema.sql
└── crud/
    └── [archivos de configuración]

nbproject/
├── private/
└── project.properties

build/
└── [archivos compilados]

test/
└── [archivos de prueba]
```

## 🎯 Funcionalidades

### Gestión de Personas
- Registro de nuevas personas
- Consulta de personas existentes
- Actualización de datos
- Eliminación de registros

### Validaciones
- Campos obligatorios
- Formato de correo electrónico
- Validación de ID
- Fechas válidas

### Roles
- Asignación de roles a personas
- Gestión de permisos

## 📝 Uso

1. Ejecutar la aplicación
2. Completar los campos requeridos:
   - Nombre
   - Apellidos
   - Correo
   - Fecha de nacimiento
   - País
   - Profesión
   - Rol

3. Utilizar los botones para:
   - Registrar nueva persona
   - Consultar persona existente
   - Editar datos
   - Eliminar registro

## 🤝 Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## ✨ Características del Código

### Principios SOLID
- **Single Responsibility Principle (SRP)**
  - Cada clase tiene una única responsabilidad
  - Separación clara entre modelo, vista y controlador

- **Open/Closed Principle (OCP)**
  - Código extensible sin modificar el existente
  - Uso de interfaces para extensibilidad

- **Interface Segregation Principle (ISP)**
  - Interfaces específicas para cada tipo de cliente
  - Sin dependencias innecesarias

- **Dependency Inversion Principle (DIP)**
  - Dependencias invertidas hacia abstracciones
  - Código de alto nivel independiente de detalles

### Patrón MVC
- **Modelo (Models)**
  - Lógica de negocio
  - Validación de datos
  - Estructura de datos

- **Vista (Views)**
  - Interfaz de usuario
  - Interacción con el usuario
  - Presentación de datos

- **Controlador (Controllers)**
  - Coordinación entre modelo y vista
  - Persistencia de datos
  - Lógica de aplicación

## 📞 Soporte

Para soporte, email: jhonhader2@hotmail.com o crear un issue en el repositorio. 