# Spring Exercise Application

## Project Overview

This application is a simple Spring Boot project demonstrating CRUD operations for managing departments and employees. It leverages Spring MVC, Thymeleaf, and Spring Data JPA for a full-stack Java web application.

## Prerequisites

- JDK 21
- Maven 3.2+
- Mysql Database

## Getting Started

To run this application:

1. Clone the repository to your local machine.
2. Ensure you have Maven installed and configured.
3. Navigate to the root directory of the project and run:
4. Access the application at `http://localhost:8080/`.

## Project Structure

- `src/main/java/net/dmsegypt/Spring/Exercise`: Main application package.
- `controller`: Contains `DepartmentController` and `EmployeeController` for web layer logic.
- `dao`: Contains `DepartmentRepository` and `EmployeeRepository` interfaces for data access.
- `entity`: Contains JPA entities `Department` and `Employee`.
- `service`: Contains service interfaces and their implementations.
- `SpringExerciseApplication`: The main class to bootstrap the application.
- `src/main/resources`: Contains application properties and static resources.
- `static/js`: Contains JavaScript files.
- `templates`: Contains Thymeleaf templates for the views.

## Features

- Add, update, and delete departments.
- Add, update, and delete employees.
- Search functionality for employees.
- Form validation and error handling.
- Responsive web design using Bootstrap.

