# \# Employee Management System (Spring Boot)

# 

# A backend RESTful application for managing employee records using \*\*Java\*\*, \*\*Spring Boot\*\*, and \*\*MySQL\*\*.  

# This project demonstrates clean backend architecture, CRUD operations, validation, and best practices.

# 

# ---

# 

# \## Features

# 

# \- Create, update, delete, and view employees

# \- Email uniqueness validation

# \- RESTful API design

# \- Exception handling with custom errors

# \- Pagination and sorting support

# \- Clean layered architecture (Controller, Service, Repository)

# 

# ---

# 

# \## Tech Stack

# 

# \- Java

# \- Spring Boot

# \- Spring Data JPA

# \- MySQL

# \- Maven

# \- Postman (API Testing)

# 

# ---

# 

# \## Project Structure

# 

# employee-management-system  

# ├── controller  

# ├── service  

# ├── repository  

# ├── entity  

# ├── exception  

# └── config  

# 

# ---

# 

# \## API Endpoints

# 

# POST   /api/employees        → Add new employee  

# GET    /api/employees        → Get all employees  

# GET    /api/employees/{id}   → Get employee by ID  

# PUT    /api/edit/{id}        → Update employee  

# DELETE /api/employees/{id}   → Delete employee  

# 

# ---

# 

# \## Validations

# 

# \- Email must be unique

# \- Throws custom exception if email already exists

# \- Prevents duplicate employee records

# 

# ---

# 

# \## How to Run

# 

# 1\. Clone the repository

# 

# git clone https://github.com/muskan-0604/employee-management-system-springboot.git

# 

# 2\. Configure MySQL in application.properties

# 

# 3\. Run the application

# 

# mvn spring-boot:run

# 

# ---

# 

# \## API Testing

# 

# Use Postman  

# Base URL:

# 

# http://localhost:8080

# 

# ---

# 

# \## Author

# 

# Muskan Pal  

# Backend Developer | Java | Spring Boot

