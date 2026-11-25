# Library Management System

I developed this Library Management System using Java and Spring Boot to manage users, books, and library details. The application also provides functionality for borrowing and returning books.

I used Spring Data JPA and Hibernate for database operations and PostgreSQL to store application data.

## Technologies Used

- Java 17
- Spring Boot 3.5.3
- Spring MVC
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman

## Features

### 1. User Management
- Implemented APIs to manage user details.
- Generated user IDs automatically.
- Maintained address information for users.

### 2. Book Management
- Implemented APIs to manage book details.
- Generated book IDs automatically.
- Maintained book information and availability status.

### 3. Library Management
- Implemented APIs to manage library details.
- Generated library IDs automatically.
- Maintained library address information.
- Established relationships between libraries and books.

### 4. Book Borrowing
- Implemented functionality for users to borrow books.
- Maintained borrowing information.
- Updated book availability status during the borrowing process.
- Recorded the borrowing time.

### 5. Book Returning
- Implemented functionality to return borrowed books.
- Updated book availability status after returning.
- Recorded the return time.

## Entity Relationships

The application contains the following main entities:

- **User:** Stores user details and address information.
- **Book:** Stores book details and maintains its relationship with users.
- **Library:** Stores library details, address information, and associated books.
- **Address:** Stores address information.

I used JPA annotations to establish relationships between these entities.

## Project Architecture

I followed a layered architecture to organize the application:

- **Controller Layer:** Handles incoming REST API requests.
- **Service Layer:** Contains the business logic.
- **DAO/Repository Layer:** Handles database operations.
- **Entity Layer:** Contains entity classes and their relationships.
- **Utility Layer:** Contains common response structures and utility classes.

## Database

I used PostgreSQL as the relational database.

Spring Data JPA and Hibernate are used for database interactions and object-relational mapping.

## How to Run the Application

1. Clone the repository.
2. Create a PostgreSQL database.
3. Configure the database connection in the application properties.
4. Import the project into Eclipse or another Java IDE.
5. Run the Spring Boot application.
6. Test the REST APIs using Postman.

## API Testing

I used Postman to test the REST APIs and verify the application operations.

## Author

Java Backend Developer
