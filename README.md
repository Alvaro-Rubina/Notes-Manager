<a id="readme-top"></a>
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Alvaro-Rubina/Notes-Manager">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

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
          <a href="#users">Users</a>
          <ul>
            <li><a href="#create-user">Create User</a></li>
            <li><a href="#find-user">Find User</a></li>
            <li><a href="#get-all-users">Get all Users</a></li>
            <li><a href="#edit-user">Edit User</a></li>
            <li><a href="#delete-user">Delete User</a></li>
          </ul>
        </li>
        <li>
          <a href="#notes">Notes</a>
          <ul>
            <li><a href="#create-note">Create Note</a></li>
            <li><a href="#find-note">Find Note</a></li>
            <li><a href="#get-all-notes">Get all Notes</a></li>
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


Notes Manger es una REST API desarollada con Spring Boot que proporcion las herramientas necesarias para de gestionar a cada usuario y sus notas de manera eficiente. Para asegurar la persistencia de los datos, se hace uso de una base de datos MySQL, permitiendo realizar operaciones como crear, editar, consultar y eliminar usuarios y notas.
El proyecto emplea una arquitectura multicapas que incluye las capas Controller, Model, Service, DTO y DAO). También se cuenta con herramientas clave como:
- **Swagger**: Para la documentación de la API.
- **MapStruct**: Para el mapeo entre entidades y DTOs.
- **Mockito**: Para la realización de pruebas unitarias.
- **Lombok**: Para reducir el código boilerplate.


<p align="right">(<a href="#readme-top">Volver al inicio</a>)</p>



### Tecnologías utilizadas

* [![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
* [![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
* [![MapStruct](https://img.shields.io/badge/MapStruct-6D7AA4?style=flat&logo=mapstruct&logoColor=white)](https://mapstruct.org/)
* [![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=white)](https://swagger.io/)
* [![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat&logo=junit&logoColor=white)](https://junit.org/)
* [![Mockito](https://img.shields.io/badge/Mockito-00303F?style=flat&logo=mockito&logoColor=white)](https://site.mockito.org/)
* [![Lombok](https://img.shields.io/badge/Lombok-2C2C2C?style=flat&logo=lombok&logoColor=white)](https://projectlombok.org/)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Primeros pasos

Para poder probar **Notes Manager** tenes que contar con lo siguiente

### Requerimientos previos

Antes que nada, asegurate de tener instalado lo siguiente en tu computadora!
- **Java 17**: El proyecto utiliza Java 17. Podés descargarlo desde [OpenJDK](https://openjdk.java.net/projects/jdk/17/) u [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **Wampserver**: Para configurar un entorno de desarrollo local que incluya MySQL y un servidor Apache. Podés descargarlo desde [WAMPServer](https://wampserver.aviatechno.net).


### Instalación

1. **Cloná el repositorio**
   
   Abrí tu línea de comandos y cloná el repositorio con el siguiente comando:
   ```sh
   git clone https://github.com/Alvaro-Rubina/Notes-Manager.git
   ```
   Después, abrí el proyecto con tu IDE de preferencia.
2. **Configurá la base de datos**
   
   Ejecutá Wampserver, ingresá a [phpMyAdmin](http://localhost/phpmyadmin/) e iniciá sesion. Por defecto, el valor para Usuario es **root** y para Contraseña nada, vacío. Pero eso depende de tu configuración!
   Una vez dentro de phpMyAdmin, creá una base de datos con el nombre que quieras (para esta demostración, la base se llama **notes**), seleccioná *utf8mb4_spanish_ci* como Cotejamiento para que no tengás problemas con caráteres como acentos; y por último creá la base.
   ![Demo del proyecto](images/db-creation.gif)
4. **Configurá las variables de entorno**

   En tu IDE //TODO//



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Feature 1
- [ ] Feature 2
- [ ] Feature 3
    - [ ] Nested Feature

See the [open issues](https://github.com/github_username/repo_name/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - email@email_client.com

Project Link: [https://github.com/github_username/repo_name](https://github.com/github_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
