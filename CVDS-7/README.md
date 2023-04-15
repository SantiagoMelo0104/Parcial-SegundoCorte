# CVDS-7
# Finalización CI/CD - Manejo de Data - ORM
# PARTE I. FINALIZACIÓNCI/CD
# Verificación APP
- Verificar funcionamiento de app MyShutle en micuenta de la nube de Azure.
- Al presionar en su URL: ej. ́https://mycvdsappname.azurewebsites.net/myshuttledev ́
- Deberá salir un pantalla mostrando la pantalla de login de MyShuttle. En caso que no, qué eslo más probable, vamos a revisarcómo mirar los errores.
![](https://github.com/SantiagoMelo0104/CVDS-7/blob/Master/imagenes/parte1.jpg)
![](https://github.com/SantiagoMelo0104/CVDS-7/blob/Master/imagenes/parte1.0.jpg)
## Troubleshooting - Activando logs
- Revisión de logs delsistema
- Ingresar al losrecursos de nuestra cuenta en la nube de Azure.
- Entrar al recurso de nuestra aplicaciónweb.
- Buscar la opción de Logs Stream, ingresar allí.Nos debe salir un mensaje que nosindica que primero debemos activar ó configurar loslogs.
- Volver a la página anterior y presionar en la opción Configure Logs.
- Vamos a configurarlos de la siguiente manera:
   - Application logging: ON(Level: Error)
   - Application login (Blob): OF
   - Web server logging: File System
   - Quota 35 MB
   - Retention Period: 3
   - Detailed error messages: ON
   - Failed request tracing: ON
- —> Guardar.
- Revisar qué está pasando a la hora de hacer login.
- Revisión delcódigo fuente
   - Descargue el repositorio de MyShuttle de su cuenta de AzureDevOps(ADO).
      - Busque el repositorio MyShuttle en su cuenta de ADO
      - Ejecute elcomando gitclone para descargar el proyecto.
      - Sí le solicita una contraseña, presione el botón Generate Git Credentials y obtenga la contraseña generada para cuando se la solicite
![](https://github.com/SantiagoMelo0104/CVDS-7/blob/Master/imagenes/parte1.1.jpg)
localmente Git.
## ContinuousIntegration - Activando la opción integración continua en el Pipeline.
- Buscar en ADO los pipelines, y editar el pipeline de nuestro proyecto.
- Activar elcheckbox de “continuousintegration” en el menú Triggers. —> Guardar.
- Ahora cuando hagamos un push,se ejecutará el pipeline de construcción de la nueva versión de nuestro proyecto.

- Para desplegarlo, ir al Menu Releases y manualmente crear un release.
- Luego de que sea exitoso podemos volver a probar nuestro sistema.
## Bugfixing - Solucionando un Bug
- Revisar en qué parte está ubicada la información de la base de datos.
- Revisa las propiedades de conexión del proyecto java a la base de datos.
- Validarcualesson los datos de conexión correctos.
- Actualizar información de conexión a la BD en la clase.
- Subir loscambios al repositorio remoto.
- Validarsi ya funciona el ajuste.

# PARTE II. USANDO SPRING DATA DESDE CERO
- Revisemoslasclases: DataAccess.java y veamosla manera en la que se crearon los métodos: login, employeeFares, getFareTotal.
- Actualmente el proyecto se conecta a la base de datos usando JDBC (Java Data Base Connection)
- Crea un nuevo repositorio en tu cuenta de github llamado cvds-7, y sigue lasinstrucciones delsiguiente tutorial de spring.
   - https://medium.com/@saultobias13/a-quick-start-with-spring-boot-and-spring-data-jpa-32718a8f4706
![](https://github.com/SantiagoMelo0104/CVDS-7/blob/Master/imagenes/2.0.png)
- Crearemos una base de datoslocal usando Docker:
- Descargar imagen de MySQL
```
   docker pull mysql
```
![](https://github.com/SantiagoMelo0104/CVDS-7/blob/Master/imagenes/2.1.png)
- Corrercontenedor de MySQL
```
   docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
```
![]()
- Descargar un cliente de base de datos: DBeaver
- Crear una tabla de la base de datos: EMPLOYEE.
- Con las siguientescolumnas:
   - EMPLOYEE_ID (VARCHAR)
   - FIRST_NAME (VARCHAR)
   - LAST_NAME (VARCHAR)
   - ROLE (VARCHAR)
   - SALARY (DOUBLE)
![]()
![]()
- Buscarcómo conectar nuestro proyecto de spring a una base de datos MySql.
