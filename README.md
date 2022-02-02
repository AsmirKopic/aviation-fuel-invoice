# Aviation fuel invoice management

A Sample Spring MVC CRUD Application with Thymeleaf, HTML5, CSS3 and Bootstrap4

## Description

In this application, you can see a demonstration of using Spring Boot, Spring Data JPA, MySQL, Spring MVC, Thymeleaf, HTML5, CSS3 and Bootstrap 
all together to build a web application.

Currently code in this repo includes entity models for related Airline and Invoice database tables, as well as controllers and views for Airlines and Invoices records.

## Installation

#### 1. Clone the application
$ git clone https://github.com/AsmirKopic/aviation-fuel-invoice.git
#### 2. Database Configuration

MySQL is used as the database.

•	Open src/main/resources/application.properties

•	If you run the application locally, change spring.datasource.username and spring.datasource.password as per your mysql installation

The project is created with Maven.

#### 3. Launch

To run the application locally:
mvn clean install

mvn spring-boot:run

commands run the application.

Application runs from localhost:8080

There are users of type admin and manager

#### Admin Credential:

username: admin  
password: user1234

#### Manager Credential:

username: manager  
password: user1234

Admin is authorized to Create, Update and Delete records for Airline and related invoices, 
while the Manager authorization/login allows only the creation and editing of records without the possibility of deleting them.

The application runs from http://localhost:8080

## Screenshots



