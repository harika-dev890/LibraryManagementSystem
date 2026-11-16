# Library Management System

## Overview
A Library Management System developed using Java and Spring Boot to manage library operations, including users, books, libraries, and borrowing and returning books.

## Technologies Used
- Java 17
- Spring Boot 3.5.3
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST APIs

## Features
- Manage users and their addresses.
- Manage book records.
- Manage library details.
- Borrow and return books.
- Track book availability.
- Maintain relationships between users, books, libraries, and addresses.
- Handle API responses using a reusable response structure.

## Project Architecture
The project follows a layered architecture:

- **Controller:** Handles incoming HTTP requests.
- **Service:** Contains business logic.
- **DAO:** Handles data access operations.
- **Repository:** Provides database operations using Spring Data JPA.
- **Entity:** Defines database entities.
- **Utility:** Contains reusable response structures.

## Database
PostgreSQL is used as the relational database, with Hibernate managing entity persistence through Spring Data JPA.

## Configuration
Configure the following environment variables before running the application:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

## Running the Application

1. Clone the repository.
2. Configure PostgreSQL database credentials.
3. Configure the required environment variables.
4. Run the application using Maven.

## Author
Harika
