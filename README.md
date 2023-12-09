# E Commerce API

E Commerce API application is a Java application built using Maven and the SpringBoot framework.

## Table of Contents

- [Frameworks and Language Used](#frameworks-and-language-used)
- [Dataflow](#dataflow)
- [Data Structure](#data-structure)
- [Project Summary](#project-summary)

## Frameworks and Language Used

- Java: The primary programming language used for developing the application.
- Maven: A build automation tool and dependency management tool used for managing the project's dependencies and building the application.
- SpringBoot: A powerful and widely used framework for building Java-based enterprise applications. It provides features like inversion of control, dependency injection, and seamless integration with various other libraries.

## Dataflow


* Entities : I have two entities in my project namely User and order . User entity has the details that user can have like id , name , email , password etc. Order also has things like order id , name , timestamp ,quantity , price etc. Both entities have bidirectional mappings with each other.
 
* Controller :The Controller layer handles incoming HTTP requests and directs them to the appropriate service. It mainly deals with request handling, validation, and response generation. so I have two controllers namely User Controller  and order Controller. In both controllers I have endpoints for crud operations and one speacial endpoits is there which will have give you the list of users who didn't order anything yet.

* Service : The Services layer contains business logic and application-specific operations. It acts as an intermediary between the Controller and the Repository, encapsulating complex functionalities. So I have two service layers for each controllers.

* Repository :The Repository layer is responsible for data access and manipulation. It communicates with the database and performs CRUD (Create, Read, Update, Delete) operations. So I have repositories for each service class. Repositories extending JPA Repositry which allowing us to do crud operations , also allow us to create custom finders and custom queries.

* DataBase Design : I have used MYSQL as my RDBMS. The database designed for this project has tables for each model. The table has columns according to the properties of models. I have used my sql connector dependency in pom for connections to my sql and in applications.properties I have all details about database authentication and name of data base and also about Driver class etc.

## Data Structure

I have used MYSQL as an database to store my data in persistant way.

## Project Summary

E commerce API is simple springboot application that allows users to orders something. I have created APIs for crud opertation on each entity like for user getUser , deleteUser , updateUserEmail,saveUser and one speacial API that will give you list of users who didn't order anything yet after getting list you can give discount to those users to grow your e commerce business.




