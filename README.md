<a id="readme-top"></a>
<br />
<div align="center">

<h3 align="center">Notes Manager</h3>

  <p align="center">
    Una API que proporciona el Backend de un gestor de notas, ofreciendo lo necesario para una cómoda gestión tanto de usuarios como de las notas que estos poseen.
    <br />
    <a href="https://github.com/Alvaro-Rubina/Notes-Manager"><strong>Observa el proyecto! »</strong></a>
    <br />
    <br />
  </p>
</div>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#acerca-de">Acerca de</a>
      <ul>
        <li><a href="#tecnologías-utilizadas">Tecnologías utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#primeros-pasos">Primeros pasos</a>
      <ul>
        <li><a href="#requerimientos-previos">Requerimientos previos</a></li>
        <li><a href="#instalación">Instalación</a></li>
      </ul>
    </li>
    <li>
      <a href="#guía-de-uso">Guía de uso</a>
      <ul>
        <li>
          <a href="#user">User</a>
          <ul>
            <li><a href="#new-user">New User</a></li>
            <li><a href="#find-user">Find User</a></li>
            <li><a href="#find-all">Find all</a></li>
            <li><a href="#edit-user">Edit User</a></li>
            <li><a href="#delete-user">Delete User</a></li>
          </ul>
        </li>
        <li>
          <a href="#note">Note</a>
          <ul>
            <li><a href="#new-note">New Note</a></li>
            <li><a href="#find-note">Find Note</a></li>
            <li><a href="#find-all">Find all</a></li>
            <li><a href="#edit-note">Edit Note</a></li>
            <li><a href="#delete-note">Delete Note</a></li>
          </ul>
        </li>
      </ul>
    </li>
    <li><a href="#contacto">Contacto</a></li>
    <li><a href="#menciones">Menciones</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Acerca de


Notes Manger es una REST API desarollada con Spring Boot que proporciona las herramientas necesarias para de gestionar usuarios y sus notas de manera eficiente. Para asegurar la persistencia de los datos, se hace uso de una base de datos MySQL, permitiendo realizar operaciones como crear, editar, consultar y eliminar usuarios y notas.
El proyecto emplea una arquitectura multicapas que incluye las capas Controller, Model, Service, DTO y DAO). También se cuenta con herramientas clave como:
- **Swagger**: Para la documentación.
- **MapStruct**: Para el mapeo entre entidades y DTOs.
- **Mockito**: Para la realización de pruebas unitarias.
- **Lombok**: Para reducir el código boilerplate.


*Proximamente se agregará autenticación*

<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>



### Tecnologías utilizadas

* [![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
* [![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
* [![MapStruct](https://img.shields.io/badge/MapStruct-6D7AA4?style=flat)](https://mapstruct.org/)
* [![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=white)](https://swagger.io/)
* [![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat)](https://junit.org/)
* [![Mockito](https://img.shields.io/badge/Mockito-00303F?style=flat)](https://site.mockito.org/)
* [![Lombok](https://img.shields.io/badge/Lombok-2C2C2C?style=flat)](https://projectlombok.org/)


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


<!-- GETTING STARTED -->
## Primeros pasos

Para poder probar **Notes Manager** tenes que contar con lo siguiente

### Requerimientos previos

Antes que nada, asegurate de tener instalado lo siguiente en tu computadora!
- **Java 17**: El proyecto utiliza Java 17. Podés descargarlo desde [OpenJDK](https://openjdk.java.net/projects/jdk/17/) u [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Wampserver**: Para configurar un entorno de desarrollo local que incluya MySQL y un servidor Apache. Podés descargarlo desde [WAMPServer](https://wampserver.aviatechno.net).


### Instalación

1. **Clonar el repositorio**
   
   Abrí tu línea de comandos y cloná el repositorio con el siguiente comando:
   ```sh
   git clone https://github.com/Alvaro-Rubina/Notes-Manager.git
   ```
   Después, abrí el proyecto con tu IDE de preferencia.
2. **Configurar la base de datos**
   
   Ejecutá Wampserver, ingresá a [phpMyAdmin](http://localhost/phpmyadmin/) e iniciá sesion. Si es la primera vez que accedés, el valor por defecto para Usuario es **root** y para Contraseña nada, vacío. Si ya ocupaste phpMyAmin con anterioridad, podes iniciar sesión de esta forma u ocupar alguna cuenta de usuario que tengas.
   Una vez dentro de phpMyAdmin, creá una base de datos con el nombre que quieras (para esta demostración, la base se llama **notes**), seleccioná *utf8mb4_spanish_ci* como Cotejamiento para que no tengás problemas con caráteres como acentos; y por último creá la base.
   ![Demo del proyecto](images/db-creation.gif)
3. **Configurar las variables de entorno**

   Para este paso vas a necesitar los datos que configuraste en el paso anterior: el usuario, contraseña y el nombre de la base de datos.
   Dentro de tu IDE vas a navegar hasta el archivo *application.properties* (`src/main/resources/application.properties`) y vas a reemplazar:
   - **${DB_URL}** por: `jdbc:mysql://localhost:3306/nombre_bd?useSSL=false&serverTimezone=UTC`

     Donde reemplazarás nombre_bd por el nombre de tu base de datos.
   - **${DB_USER_NAME}** por tu usuario (si no lo cambiaste, sigue siendo `root`)
   - **${DB_PASSWORD}** por tu contraseña (si no la cambiaste, deja el campo vacío)
  
     Alternativamente, podés optar por no reemplazar dichos campos y en su lugar configurar las variables de entorno del proyecto desde las configuraciones de tu IDE. Abajo hay una demostración de cómo hacerlo desde IntelliJ
     ![Configuracion variables de entorno](images/env-variables.gif)
  4. **Ejecutar el proyecto**

     Si ya realizaste todos los pasos anteriores, ya estás en condiciones de comenzar. Dirigite a la clase NotesManaggerApplication (`src/main/java/org/alvarub/notesmanager/NotesManagerApplication.java`) ya que es la que contiene el método main y ejecutala. Se va a abrir una consola donde muestran logs indicando el estado actual de la ejecución, y si todo está en orden, al final vas a ver un log como el siguiente:

```log
2024-08-09T18:12:25.424-03:00  INFO 20580 --- [notes-manager] [  restartedMain] o.a.n.NotesManagerApplication            : Started NotesManagerApplication in XX.XXX seconds (process running for XX.XXX)
```

Arriba de ese log, vas a ver también otro log como este:
```log
2024-08-09T18:27:15.554-03:00  INFO 20580 --- [notes-manager] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
```
Este log también es importante, puesto que nos indica en que puerto se desplegó **Tomcat**, que es un servidor embebido que provee Spring Boot para desplegar la aplicación de forma local. El puerto por defecto que utiliza Tomcat es el 8080, que es donde se manejan las solicitudes HTTP que profundizaremos en la siguiente sección.
Por último, si vas a phpMyAdmin y revisas la base de datos, vas a ver que se crearon de forma automáticamente las tablas **User** y **Note** junto con sus correspondientes columnas.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


<!-- USAGE EXAMPLES -->
## Guía de uso

En esta sección se demuestra el funcionamiento de cada endpoint mediante ejemplos de solicitudes HTTP, de esta forma vas a comprender cómo realizar un CRUD tanto de Usuarios como Notas.  
Antes de profundizar, dirigite a la siguiente dirección en tu navegador: http://localhost:8080/swagger-ui/index.html. Cuando hayas accedido, te vas a encontrar con una interfaz visual amigable que proporciona Swagger, donde se documentaron los endpoints.

Mas adelante se muestran ejemplos realizados mediante la interfaz que brinda Swagger. Si deseas probar los endpoints mediante Postman, accede a colección con el siguiente botón:

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://app.getpostman.com/run-collection/33441736-6b60df2c-fc2f-46c4-97d6-56dadc13a173?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D33441736-6b60df2c-fc2f-46c4-97d6-56dadc13a173%26entityType%3Dcollection%26workspaceId%3D86789605-6875-4391-8327-7c3a778f18dd)

### User 
---

Dentro de la sección de User se encuentran los endpoints para las distintas solicitudes y una pequeña descripción de lo que hacen.

#### New User

Para registrar un nuevo usuario: HTTP REQUEST **POST** en `/users/new`.

- En el cuerpo de la request se envía un objeto `NewUserDTO` en formato JSON que luego es mapeado a un objeto `User` para ser agregado a la BBDD.
- Todos los parámetros son obligatorios.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo POST USER 1](images/post-user-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo POST USER 2](images/post-user-2.png)
</p>

Responses:
- `201`: Usuario registrado.
- `400`: Parámetros inválidos.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Find User

Para encontrar un usuario: HTTP REQUEST **GET** en `/users/find/{id}`.

- En el URL se envía el ID del usuario como parámetro.
- Devuelve un objeto `UserDTO`.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo GET USER 1](images/get-user-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo GET USER 2](images/get-user-2.png)
</p>

Responses:
- `200`: Usuario encontrado.
- `404`: Usuario no encontrado.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Find all

Para encontrar todos los usuarios registrados: HTTP REQUEST **GET** en `/users/find-all`.

- Sin parámetros y sin cuerpo.
- Devuelve una lista de objetos `UserDTO`. Si no hay usuarios, devuelve una lista vacía.

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo GET ALL USERS](images/get-all-users.png)
</p>

Responses:
- `200`: OK.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Edit User

Para editar un usuario: HTTP REQUEST **PUT** en `/users/edit/{id}`.

- En el URL se envía el ID del usuario a editar como parámetro.
- En el cuerpo de la request se envía un objeto `NewUserDTO` en formato JSON con los datos del usuario que van a ser editados. No es obligatorio enviar todos los datos, solo los que van a ser editados.
- El ID en el URL es **OBLIGATORIO**.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo EDIT USER 1](images/edit-user-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo EDIT USER 2](images/edit-user-2.png)
</p>

Si buscamos al usuario con ID = 1 luego de editarlo:

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo EDIT USER 3](images/edit-user-3.png)
</p>

Responses:
- `200`: Usuario actualizado.
- `400`: Parámetros inválidos.
- `404`: Usuario no encontrado.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Delete User

Para eliminar un usuario: HTTP REQUEST **DELETE** en `/users/delete/{id}`.

- En el URL se envía el ID del usuario a eliminar como parámetro.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo DELETE USER](images/delete-user.png)
</p>

RESPONSES:
- `200`: Usuario eliminado.
- `404`: Usuario no encontrado.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


### Note
---

Dentro de la sección de Note se encuentran los endpoints para las distintas solicitudes y una pequeña descripción de lo que hacen.

#### New Note

Para guardar una nueva nota: HTTP REQUEST **POST** en `/notes/new`.

- En el cuerpo de la request se envía un objeto `NewNoteDTO` en formato JSON que luego es mapeado a un objeto `Note` para ser agregado a la BBDD.
- Todos los parámetros son obligatorios.
- creatorID hace referencia al usuario que ha creado la nota.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo POST NOTE 1](images/post-note-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo POST NOTE 2](images/post-note-2.png)
</p>

Responses:
- `201`: Nota creada.
- `400`: Parámetros inválidos.
- `404`: Usuario no encontrado.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Find Note

Para encontrar una nota: HTTP REQUEST **GET** en `/notes/find/{id}`.

- En el URL se envía el ID de la nota como parámetro.
- Devuelve un objeto `NoteDTO`.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo GET NOTE 1](images/get-note-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo GET NOTE 2](images/get-note-2.png)
</p>

Responses:
- `200`: Nota encontrada.
- `404`: Nota no encontrada.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Find all

Para encontrar todas las notas guardadas: HTTP REQUEST **GET** en `/notes/find-all`.

- Sin parámetros y sin cuerpo.
- Devuelve una lista de objetos `NoteDTO`. Si no hay notas, devuelve una lista vacía.

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo GET ALL NOTES](images/get-all-notes.png)
</p>

Responses:
- `200`: OK.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Edit Note

Para editar una nota: HTTP REQUEST **PUT** en `/notes/edit/{id}`.

- En el URL se envía el ID de la nota a editar como parámetro.
- En el cuerpo de la request se envía un objeto `NewNoteDTO` en formato JSON con los datos de la nota que van a ser editados. No es obligatorio enviar todos los datos, solo los que van a ser editados.
- El ID en el URL es **OBLIGATORIO**.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo EDIT NOTE 1](images/edit-note-1.png)
</p>

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo EDIT NOTE 2](images/edit-note-2.png)
</p>

Si buscamos a la nota con ID = 1 luego de editarla:

<p align="center">Response</p>
<p align="center">
  
  ![Ejemplo EDIT NOTE 3](images/edit-note-3.png)
</p>

Responses:
- `200`: Nota actualizada.
- `400`: Parámetros inválidos.
- `404`: Nota o usuario no encontrado.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


#### Delete Note

Para eliminar una nota: HTTP REQUEST **DELETE** en `/notes/delete/{id}`.

- En el URL se envía el ID de la nota a eliminar como parámetro.

<p align="center">Request</p>
<p align="center">
  
  ![Ejemplo DELETE NOTE](images/delete-note.png)
</p>

RESPONSES:
- `200`: Nota eliminada.
- `404`: Nota no encontrada.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>


<!-- CONTACT -->
## Contacto

Alvaro Rubina - [Linkedin](https://www.linkedin.com/in/alvaro-rubina/) - alvarorubina132@gmail.com

Link del proyecto: [https://github.com/Alvaro-Rubina/Notes-Manager](https://github.com/Alvaro-Rubina/Notes-Manager)

<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Menciones

* [Plantilla utilizada para el README](https://github.com/othneildrew/Best-README-Template)

<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>
