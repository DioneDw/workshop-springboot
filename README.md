<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/store.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Webservice Store Project</h3>

  <p align="center">
    Projeto de webservice de uma loja com SpringBoot!
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
</div>

<details>
  <summary>Tabela de conteúdos</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o projeto</a>
      <ul>
        <li><a href="#tecnologiasferramentas-usadas">Tecnologias utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#como-iniciar-o-projeto">Como iniciar o projeto</a>
      <ul>
        <li><a href="#pre-requisitos">Pré-requisitos</a></li>
        <li><a href="#instalacao">Instalação</a></li>
      </ul>
    </li>
    <li><a href="#utilizando">Utilizando</a></li>
    <li><a href="#contato">Contato</a></li>
    <li><a href="#conhecimentos-adquiridos-e-melhorias">Conhecimentos Adquiridos e melhorias</a></li>
  </ol>
</details>


## :mag_right: Sobre o projeto
O projeto é a construção de um Web Service utilizando a linguagem Java versão 17 e o framework SpringBoot versão 3 para uma Loja. O objetivo foi criar uma aplicação backend utilizando as boas práticas e o padrão API Rest, possibilitando através dos seus endpoints realizar as operações CRUD para as principais entidades da base de dados: usuários, produtos, categorias e pedidos.

Características do projeto:
* Lógica de camâdas.
* API no padrão REST.
* Documentação completa com ferramenta SpringDoc Open Api (Swagger).
* Perfil de teste (utilizado banco de dados em memória H2 para facilitação do desenvolvimento).
* Pefil de homologação (utilização de Docker com banco de dados Postgresql e ferramenta pgAdmin).
* Perfil de produção (utilização de ferramenta Render e deploy de imagem da aplicação e banco executando em nuvem).

Por utilizar 3 perfis o projeto possibilita aplicar diferentes ferramentas e técnicas, para a construção de uma aplicação que utiliza a lógica de camadas (Recursos, Serviços e Repositórios).


### Padrão de camadas
<img src="images/layers.png" align="center"/>

A ilustração acima que detalha como funciona a comunicação e transmissão de dados entre as camadas da aplicação. Uma aplicação que irá consumir a API, como por exemplo o navegador Google Chrome, Postman ou outros realiza a requisição a camada de recursos (Resource Layer), essa camada onde tem os controladores Rest, essas classes irão realizar a chamada do método especifico para uma classe de serviço (Service Layer), e este por fim utiliza a uma interface específica (repository) para ter acesso aos dados (Data Access Layer). Também temos as classes entidades que fornecem o modelo dos dados conforme o seu tipo.

### Diagrama UML

<img src="images/diagram.png" align="center"/>

O diagrama UML (Unified Modeling Language) acima ilustra os aspectos do sistema como relacionamentos, comportamento, estrutura e funcionalidade. 

Inicialmente podemos destacar que o projeto possui 6 classes principais com relacionamentos entre si. Temos um Enumeração que representa o status do pedido de forma fixa.

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

## :gear: Tecnologias/Ferramentas usadas
Abaixo temos todas as tecnologias/ferramentas utilizadas durante o desenvolvimento da aplicação. 
* [![Java][Java-badge]][Java-url]
* [![Spring Boot][SpringBoot-badge]][SpringBoot-url]
* [![SpringDoc][SpringDoc-badge]][SpringDoc-url]
* [![Docker][Docker-badge]][Docker-url]
* [![Docker Compose][DockerCompose-badge]][DockerCompose-url]
* [![Maven][Maven-badge]][Maven-url]
* [![H2 Database][H2-badge]][H2-url]
* [![PostgreSQL][Postgresql-badge]][Postgresql-url]
* [![pgAdmin][PgAdmin-badge]][PgAdmin-url]
* [![Render][Render-badge]][Render-url]
* [![Postman][Postman-badge]][Postman-url]

[Java-badge]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/

[SpringBoot-badge]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot

[SpringDoc-badge]: https://img.shields.io/badge/SpringDoc-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[SpringDoc-url]: https://springdoc.org/

[Docker-badge]: https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/

[DockerCompose-badge]: https://img.shields.io/badge/Docker_Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white
[DockerCompose-url]: https://docs.docker.com/compose/

[Maven-badge]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[Maven-url]: https://maven.apache.org/

[H2-badge]: https://img.shields.io/badge/H2_Database-003366?style=for-the-badge&logo=h2&logoColor=white
[H2-url]: https://www.h2database.com/

[Postgresql-badge]: https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white
[Postgresql-url]: https://www.postgresql.org/

[PgAdmin-badge]: https://img.shields.io/badge/pgAdmin-316192?style=for-the-badge&logo=postgresql&logoColor=white
[PgAdmin-url]: https://www.pgadmin.org/

[Render-badge]: https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=white
[Render-url]: https://render.com/

[Postman-badge]: https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white
[Postman-url]: https://www.postman.com/

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>
