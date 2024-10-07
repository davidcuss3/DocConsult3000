# Sistema de Gestión de Citas Médicas

Este proyecto es un sistema de gestión de citas médicas en Java. Permite a los usuarios registrar doctores, pacientes y citas, así como guardar esta información en un archivo CSV.

## Requisitos

- JDK 8 o superior
- Un entorno de desarrollo compatible con Java (Eclipse, IntelliJ IDEA, etc.)

## Estructura del Código

El código se organiza en varias clases principales:

1. **Doctor**: Representa a un doctor con atributos como nombre, ID y especialidad. Incluye métodos para escanear, mostrar detalles y exportar a formato CSV.
  
2. **Paciente**: Representa a un paciente con atributos como nombre, ID y edad. También incluye métodos para escanear, mostrar detalles y exportar a formato CSV.
  
3. **Cita**: Representa una cita médica que incluye un ID de cita, el doctor, el paciente y la fecha de la cita. Tiene métodos para escanear, mostrar detalles, y generar un ID de cita único basado en las iniciales del doctor y del paciente.

## Funcionalidades

El sistema permite a los usuarios:

- **Iniciar sesión**: Con credenciales predeterminadas (usuario: `admin`, contraseña: `adminpassword`).
- **Registrar Doctores**: Introducir datos del doctor (nombre, ID, especialidad).
- **Registrar Pacientes**: Introducir datos del paciente (nombre, ID, edad).
- **Registrar Citas**: Asociar un paciente y un doctor a una fecha específica para crear una cita.
- **Mostrar Detalles de Citas**: Consultar los detalles de las citas registradas.
- **Guardar Datos**: Exportar los datos de doctores, pacientes y citas a un archivo CSV (`datos.csv`).

## Instrucciones de Uso

1. **Compila el código**: Abre el proyecto en tu IDE y compílalo.
  
2. **Ejecuta el programa**: Inicia el programa. Se te pedirá que introduzcas un nombre de usuario y una contraseña.
  
3. **Selecciona una opción del menú**: Una vez que inicies sesión, se te presentará un menú con varias opciones:
   - Introducir datos del Doctor
   - Introducir datos del Paciente
   - Introducir Cita
   - Mostrar detalles de las Citas
   - Guardar datos en archivo CSV
   - Salir

4. **Sigue las instrucciones en pantalla**: Para cada opción, se te guiará sobre cómo introducir la información necesaria.

5. **Verifica el archivo CSV**: Después de guardar los datos, puedes encontrar el archivo `datos.csv` en el mismo directorio donde se ejecuta el programa.

## Ejemplo de Uso

1. **Iniciar sesión**:
   - Nombre de usuario: `admin`
   - Contraseña: `adminpassword`

2. **Registrar un doctor**:
   - Nombre del Doctor: Dr. Juan Pérez
   - ID del Doctor: 101
   - Especialidad: Cardiología

3. **Registrar un paciente**:
   - Nombre del Paciente: María López
   - ID del Paciente: 202
   - Edad: 30

4. **Registrar una cita**:
   - Selecciona el doctor y el paciente registrados.
   - Introduce la fecha de la cita en formato aaaa-mm-dd.

5. **Guardar los datos**: Selecciona la opción para guardar los datos y verifica que `datos.csv` se haya creado correctamente.

## Contribuciones

Las contribuciones son bienvenidas. Si tienes sugerencias o mejoras, no dudes en abrir un issue o enviar un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
