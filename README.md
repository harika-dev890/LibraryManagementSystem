# Library Management System

A backend application developed using **Java 17 and Spring Boot** to manage library operations, including book management, user management, and book borrowing and returning.

The application follows a layered architecture with controllers, services, repositories, and DAO components to maintain separation of concerns and organized business logic.

## Technologies Used

- **Language:** Java 17
- **Framework:** Spring Boot 3.5.3
- **ORM:** Spring Data JPA, Hibernate
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **API Testing:** Postman

## Key Features

### 1. User Management
- Manage library user records.
- Generate user IDs using database identity generation.
- Associate users with address information.

### 2. Book Management
- Manage book records.
- Generate book IDs automatically.
- Maintain book-related information.
- Associate books with library users as implemented in the application.

### 3. Library Management
- Manage library information.
- Maintain library address details.
- Associate books with the library.
- Manage library-related operations.

### 4. Book Borrowing
- Allow users to borrow books.
- Track book borrowing information.
- Maintain the availability status of books.
- Record borrowing-related timestamps.

### 5. Book Returning
- Allow borrowed books to be returned.
- Update book availability after returning.
- Maintain return-related information.

### 6. Database Management
- PostgreSQL integration.
- Entity mapping using JPA and Hibernate.
- Automatic ID generation.
- Entity relationships and persistence management.

### 7. API Response Handling
- Layered application architecture.
- Centralized response structure.
- Separation of controller, service, DAO, and repository responsibilities.

## Entity Relationships

The application contains the following main entities:

| Entity | Responsibility |
|---|---|
| User | Stores library user information |
| Book | Stores book information |
| Library | Stores library information and associated books |
| Address | Stores address details |

Entity relationships are managed using JPA annotations.

## Project Architecture

The application follows a layered architecture:

1. **Controller Layer:** Handles incoming REST API requests.
2. **Service Layer:** Contains business logic and application operations.
3. **DAO/Repository Layer:** Handles database access and persistence.
4. **Entity Layer:** Represents database tables and entity relationships.
5. **Response Layer:** Provides structured API responses.

## Database

PostgreSQL is used as the relational database.

Spring Data JPA and Hibernate are used for object-relational mapping and database interactions.

## Project Structure

```text
LibraryManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── dao/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   └── util/
│   │   └── resources/
│   └── test/
├── pom.xml
└── README.md
```

## Configuration

Configure your PostgreSQL database connection in the application configuration file.

Do not commit actual database credentials to the repository.

## How to Run

1. Clone the repository.
2. Create a PostgreSQL database.
3. Configure the database connection.
4. Import the project into Eclipse or another Java IDE.
5. Build and run the Spring Boot application.
6. Test the REST APIs using Postman.

## API Testing

Postman can be used to test the user, book, library, borrowing, and returning operations.

## Author

**Java Backend Developer**
